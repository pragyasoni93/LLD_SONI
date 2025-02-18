package abc.demo.gamingleaderboad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LeaderBoardService {
    private static final String LEADERBOARD_KEY="game_leaderboard";

    private ZSetOperations<String, String> zSetOperations;

    @Autowired
    public LeaderBoardService(StringRedisTemplate stringRedisTemplate) {
        this.zSetOperations = stringRedisTemplate.opsForZSet();
    }

    public void updatePlayerScore(String player, double score){
        Double excistingScore = zSetOperations.score(LEADERBOARD_KEY, player);
        double updatedScore = (excistingScore!=null)?excistingScore+score:score;
        zSetOperations.add(LEADERBOARD_KEY, player, updatedScore);
    }

    public Long getPlayerRank(String player){
        Long rank = zSetOperations.reverseRank(LEADERBOARD_KEY, player);
        return (rank!=null)?rank+1:null;
    }

    public Set<ZSetOperations.TypedTuple<String>> getTopNPlayers(int n){
        return zSetOperations.reverseRangeByScoreWithScores(LEADERBOARD_KEY, 0, n-1);
    }
}
