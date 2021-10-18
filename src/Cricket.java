import java.util.HashSet;
import java.util.TreeMap;

public class Cricket {
    public static TreeMap<Integer,String> createPlayerPositionMap(String cricketDataset){
        TreeMap<Integer,String> map = new TreeMap<>();
        String[] dataSet = cricketDataset.split("\\|");
        for (String dSet: dataSet){
            String[] data = dSet.split(",");
            Integer pos = Integer.parseInt(data[0]);
            String p = data[1];
            map.put(pos,p);
        }
        return map;
    }

    public static TreeMap<String,Integer> createPlayerScoreMap(String cricketDataset){
        TreeMap<String,Integer> map = new TreeMap<>();
        String[] dataSet = cricketDataset.split("\\|");
        for (String dSet: dataSet){
            String[] data = dSet.split(",");

            String p = data[1];
            Integer score = Integer.parseInt(data[2]);
            map.put(p,score);
        }
        return map;
    }

    public static TreeMap<String,Double> createMatchesMap(String cricketDataset){
        String[] dataSet = cricketDataset.split("\\|");
        TreeMap<String,Score> finalMap = new TreeMap<>();
        for (String dSet: dataSet){
            String[] data = dSet.split(",");
            Integer score = Integer.parseInt(data[2]);
            String p = data[1];
            if(finalMap.containsKey(p)){
                Score sc = finalMap.get(p);
                sc.count++;
                sc.score += score;
                finalMap.put(p,sc);
            }
            else {
                finalMap.put(p, new Score(score,1));
            }
        }
        TreeMap<String,Double> scoreMap = new TreeMap<>();

        for (String p : finalMap.keySet()){
            double v = finalMap.get(p).score/(double) finalMap.get(p).count;
            scoreMap.put(p,v);
        }
        return scoreMap;
    }

    public static String getQuery(String cricketDataset, String query){
        String str ="";
        String[] queryData = query.split(" ");
        int queryType = Integer.parseInt(queryData[0]);
        if(queryType == 1){
            TreeMap<Integer,String> map = createPlayerPositionMap(cricketDataset);
            for(Integer pos: map.keySet()){
                int startPos = Integer.parseInt(queryData[1]);
                int endPos = Integer.parseInt(queryData[2]);
                if(pos>= startPos && pos<=endPos){
                    str += ""+pos+" "+map.get(pos)+"\n";
                }

            }
        }
        if(queryType == 2){
            TreeMap<Integer,String> posMap = createPlayerPositionMap(cricketDataset);
            TreeMap<String,Integer> scoreMap = createPlayerScoreMap(cricketDataset);
            HashSet<String> players = new HashSet<>();
            for(String p: scoreMap.keySet()){
                int threshold = Integer.parseInt(queryData[1]);
                if(threshold<= scoreMap.get(p)){
                    players.add(p);
                }
            }
            for (Integer pos:posMap.keySet()){
                if(players.contains(posMap.get(pos))){
                    str += ""+pos+" "+posMap.get(pos)+"\n";
                }
            }
        }

        if(queryType == 3){
            TreeMap<String,Double> scoreMap = createMatchesMap(cricketDataset);
            double max = 0.0;
            String player =null;
            for(String p: scoreMap.keySet()){
                if(scoreMap.get(p) >= max){
                    max = scoreMap.get(p);
                    player = p;
                }
            }
            str += "The Efficient Player is "+player+"\n";
        }

        return str;
    }
    public static class Score{
        public int count;
        public double score;

        public Score(int count, double score) {
            this.count = count;
            this.score = score;
        }
    }
    public static void main(String[] args){
        String dataSet = "3,Dhoni,120|1,Virat,103|5,Jadeja,30|2,Rohit,70|4,Pandya,40";
        System.out.println(getQuery(dataSet,"1 3 5"));
        System.out.println(getQuery(dataSet,"2 50"));

        String dataSet3 = "3,Rohit,10|3,Rohit,13|3,Jadeja,30|2,Rohit,60|4,Pandya,40|3,Rohit,100|3,Rohit,103|3,Jadeja,30|2,Rohit,70|4,Pandya,40";
        System.out.println(getQuery(dataSet3,"3"));
    }
}
