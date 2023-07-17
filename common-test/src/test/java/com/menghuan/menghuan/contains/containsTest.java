package java.com.menghuan.menghuan.contains;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: menghuan
 * @Date: 2022/3/21 18:13
 */
public class containsTest {

    @Test
    public void sss(){

        List<Integer> filterList = new ArrayList<>();
        filterList.add(2);
        filterList.add(6);
        filterList.add(4);
        filterList.add(8);
        filterList.add(10);
        filterList.add(12);
        filterList.add(14);
        //filterList.add(18);
        filterList.add(20);

        List<IotStructure> structureList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            IotStructure iotStructure = new IotStructure();
            iotStructure.setId(i+1);
            iotStructure.setLevel(2);
            if (i%2 != 0){
                iotStructure.setLevel(1);
                System.out.println("iotStructure:" + iotStructure);
            }else {
                iotStructure.setLevel(2);
            }
            structureList.add(iotStructure);


        }

        List<IotStructure> oneList = new ArrayList<>();
        for (IotStructure iotStructure : structureList) {
            if (2== iotStructure.getLevel()){
                System.out.println("iotStructure:" + iotStructure);
            }else {
                oneList.add(iotStructure);
            }
        }
        System.out.println("========================================================");
        for (IotStructure iotStructure : oneList) {
            System.out.println("oneList:" + iotStructure);
        }


        System.out.println("========================================================");

        List<Integer> removeList = oneList.stream().filter(a -> !filterList.contains(a.getId())).map(IotStructure::getId).collect(Collectors.toList());
        for (Integer integer : removeList) {
            System.out.println("removeList:" + integer);
        }

        /*for (IotStructure iotStructure : collect) {
            System.out.println("collect:" + iotStructure);
        }*/

        System.out.println("==========================END==============================");
        List<Integer> finalCollect = structureList.stream().filter(a -> !removeList.contains(a.getId())).map(IotStructure::getId).collect(Collectors.toList());
        for (Integer integer : finalCollect) {
            System.out.println("finalCollect:" + integer);
        }

    }
}
