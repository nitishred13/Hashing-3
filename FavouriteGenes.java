import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//First we map each song to its genre using the genreMap.
//Then for every user, we count how many songs belong to each genre.
//The genre(s) with the highest count is added to that user’s favorite list.

//Time Complexity: O(U*S)
//Space Complexity:O(S)
public class FavouriteGenes {
   public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
   //create songtogenremap
    //loop through genremap 
      // for each songs list corresponding to genre, add song-genere entry to hm
   Map<String,String> hm = new HashMap<>();
   
   for(String genre:genreMap.keySet())
   {
      for(String song:genreMap.get(genre))
      {
        hm.put(song,genre);
      }
   }

   //loop through each user
        //make frequency map of genre and track maximum
    HashMap<String,List<String>> result = new HashMap<>();
   for(String user:userMap.keySet())
   {
    result.put(user,new ArrayList<>()); 
    HashMap<String,Integer> frqMap = new HashMap<>();
    int max = 0;
    for(String song:userMap.get(user))
    {
        String genre = hm.get(song);
        frqMap.put(genre,frqMap.getOrDefault(genre, 0)+1);
        if(max<frqMap.get(genre))
        {
            result.get(user).clear();
            result.get(user).add(genre);
        }
        else if(max==frqMap.get(genre))
        {
            result.get(user).add(genre);
        }
        max = Math.max(max,frqMap.get(genre));
    }
   }
   return result;
   
}

public static void main(String[] args) {
        HashMap<String, List<String>> userSongs = new HashMap<>();

        userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));

        userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));

        HashMap<String, List<String>> songGenres = new HashMap<>();

        songGenres.put("Rock", Arrays.asList(new String[]{"song1", "song3"}));

        songGenres.put("Dubstep", Arrays.asList(new String[]{"song7"}));

        songGenres.put("Techno", Arrays.asList(new String[]{"song2", "song4"}));

        songGenres.put("Pop", Arrays.asList(new String[]{"song5", "song6"}));

        songGenres.put("Jazz", Arrays.asList(new String[]{"song8", "song9"}));

        Map<String, List<String>> res = favoritegenre(userSongs, songGenres);

        System.out.println(res);
} 
}
