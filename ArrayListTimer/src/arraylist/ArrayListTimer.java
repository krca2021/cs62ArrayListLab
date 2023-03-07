package arraylist;

public class ArrayListTimer {
    
    private static Stopwatch watch = new Stopwatch();

    public static double run(int maxSize, int capacityIncrement){
        CapacityArrayList<String> tester = new CapacityArrayList<String>(2, capacityIncrement);
        
        System.gc();
        
        watch.start();

        for (int i=0; i<maxSize; i++){
            tester.add("KTJ");
        }
        
        return (double) watch.elapsedTime();
    }
    public static CapacityArrayList<Double> trial(int maxSize, CapacityArrayList<Integer> capacityIncrements){
        CapacityArrayList<Double> trialRecord = new CapacityArrayList<Double>(maxSize);

        for(int i=0; i<capacityIncrements.size(); i++){
            trialRecord.add(run(maxSize, capacityIncrements.get(i)));
        }

        return trialRecord;
    }
    public static void main(String[] args) {
        int maxSizeArray[]={1000,2000,4000,8000,16000,24000, 48000};

        CapacityArrayList<Integer> capacityIncrements = new CapacityArrayList();
        capacityIncrements.add(1);
        capacityIncrements.add(10);
        capacityIncrements.add(0);

        CapacityArrayList<Double> results = new CapacityArrayList();

        System.out.format("Size %-7s | Linear(1) %-2s |Linear(10) %-1s| Double %-2%n", "", "", "", "");
        System.out.println();
        System.out.println("----------------------------------------------------");
        for (int i=0;i<maxSizeArray.length; i++){
            results = trial((maxSizeArray[i]),capacityIncrements);
            System.out.format("%-12d | %-12f |%-12f |%-12f%n", maxSizeArray[i], results.get(0), results.get(1), results.get(2));
        }
    }

}
