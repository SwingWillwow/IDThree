import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ID3Util {

    Boolean [] visit = new Boolean[5];
    Double [] informationEntropy = new Double[5];
    public ID3Util(){

    }
    public void runIDThreeAlgorithm(List<Employee> employeeList){
        LinkedList<List<Employee>> algoQueue = new LinkedList<>();
        algoQueue.offer(employeeList);
        while(algoQueue.peek()!=null){
            List<Employee> currentCollection = algoQueue.poll();
            int index = selectAttr(currentCollection);
            while(currentCollection.size()!=0){
                //TO DO
            }
        }
    }
    //选择划分属性
    private int selectAttr(List<Employee> employeeList){
        int index = -1;
        Double maxInformationEntropy = 0.0;
        for(int i=0;i<5;i++){
            informationEntropy[i] = CountInformationEntropy(i);
            if(maxInformationEntropy<informationEntropy[i]){
                maxInformationEntropy = informationEntropy[i];
                index = i;
            }
        }
        return index;
    }

    //计算某一属性值的平均信息量
    private Double CountInformationEntropy (int index){

        return 0.0;
    }
}
