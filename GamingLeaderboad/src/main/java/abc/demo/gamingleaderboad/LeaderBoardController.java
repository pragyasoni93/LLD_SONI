package abc.demo.gamingleaderboad;

import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/leaderboard")
public class LeaderBoardController {

    private LeaderBoardService leaderBoardService;

    public LeaderBoardController(LeaderBoardService leaderBoardService){
        this.leaderBoardService = leaderBoardService;
    }

    @PostMapping("/update")
    public String updatePlayerScore(String player, double score){
        leaderBoardService.updatePlayerScore(player, score);
        return "Score update for : "+player;
    }

    @GetMapping("/rank")
    public String getPlayerRank(@RequestParam String player){
        Long rank = leaderBoardService.getPlayerRank(player);
        return (rank!=null)?player +" rank is : "+rank : "Player not found";
    }

    @GetMapping("/top/{count}")
    public List<Map<String, Object>> getTopPlayers(@PathVariable int count){
        Set<ZSetOperations.TypedTuple<String>> topPlayers = leaderBoardService.getTopNPlayers(count);
        List<Map<String, Object>> result = new ArrayList<>();

        int rank = 1;
        for(ZSetOperations.TypedTuple<String> entry : topPlayers){
            Map<String , Object> playerData = new HashMap<>();
            playerData.put("rank", rank++);
            playerData.put("player", entry.getValue());
            playerData.put("score", entry.getScore());
            result.add(playerData);
        }
        return result;
    }

}
