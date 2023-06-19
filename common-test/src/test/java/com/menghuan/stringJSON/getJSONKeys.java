package com.menghuan.stringJSON;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author:menghuan
 * @Date:2020/6/15 16:03
 */
public class getJSONKeys {


    /**
     * @param json 需要处理的json数据 - JSONObject
     * @param k    key
     * @param list 空 list
     * @return list
     */
    public static List getJSONValue(JSONObject json, String k, List<String> list) {
        for (Object j : json.keySet()) {
            if (isJSONObj(json.get(j))) {
                //是对象
                JSONObject j2 = JSON.parseObject(json.get(j).toString());
                getJSONValue(j2, k, list);
            } else if (isJSONArray(json.get(j))) {
                JSONArray j3 = JSON.parseArray(json.get(j).toString());
                //是数组
                getJSONValue(j3, k, list);
            } else if (j == "uri") {
                String s = json.get(j).toString();

                Map<String, Object> map = Maps.newHashMap();
                map.put("cat/meng1.jpg", 1);
                map.put("cat/red/blue/huan1.jpg", 2);
                map.put("1/0/1/m.cmpt", 3);

                //是字符串
                list.add(json.get(j).toString());
                String mh = json.get(j).toString();
                System.out.println("处理前-需要替换的路径：" + mh);

                String substring = mh.substring(mh.indexOf("/") + 1);
                System.out.println("处理后-需要替换的路径：" + substring);

                // key
                for (String key : map.keySet()) {

                    if (key.equals(substring)) {
                        System.out.println("我是匹配的value" + map.get(key));
                        map.put(key, "可怕的云服务");
                    }
                }
                /*Map<String, Object> jsonResultMap = new HashMap<>();
                jsonResultMap.put("jsonResultMap","\"cat/meng1.jpg\": {\n" +
                        "            \"bucketName\": \"iot\",\n" +
                        "            \"fileName\": \"cat-meng1.jpg\"\n" +
                        "        },\n" +
                        "        \"cat/red/blue/huan1.jpg\": {\n" +
                        "            \"bucketName\": \"iot\",\n" +
                        "            \"fileName\": \"cat-red-blue-huan1.jpg\"\n" +
                        "        },\n" +
                        "        \"cat/meng2.jpg\": {\n" +
                        "            \"bucketName\": \"iot\",\n" +
                        "            \"fileName\": \"cat-meng2.jpg\"\n" +
                        "        }");*/
            }
        }
        System.out.println("list:" + list);
        return list;
    }

    public static void getJSONValue(JSONArray json, String k, List<String> list) {
        for (Object j : json) {
            if (isJSONObj(j)) {
                //是对象
                getJSONValue((JSONObject) j, k, list);
            } else if (isJSONArray(j)) {
                //是数组
                getJSONValue((JSONArray) j, k, list);
            }
        }
    }

    public static boolean isJSONObj(Object json) {
        return json instanceof JSONObject;
    }

//    public static void getJSONValue(JSONArray json,String k,List<String> list){
//        json.stream()
//                .filter(f->isJSONObj(f))
//                .filter(f->isJSONArray(f))
//                .map(m->{
//                    if(isJSONObj(m)){
//                        //是对象
//                        getJSONValue((JSONObject) m,k,list);
//
//                    }else if(isJSONArray(m)){
//                        //是数组
//                        getJSONValue((JSONArray) m,k,list);
//                    }
//                    return null;
//                });
//
//    }

    public static boolean isJSONArray(Object json) {
        return json instanceof JSONArray;
    }

    public static <T> T jsonParse(Object json) {
        if (isJSONObj(json)) {
            //是对象
            return (T) json;
        } else {
            //是数组
            return (T) json;
        }
    }

    /**
     * 递归算法-获取json指定key的所有值
     *
     * @author zheng
     */
    @Test
    public void getJSONKeys() {
        try {
            /*File file = new File(getJSONValue2.class.getResource("../tileset.json").getPath());
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            StringBuffer json = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                json.append(line);
            }*/
            JSONObject jsonObject = new JSONObject();


            String json = "{\n" +
                    "\t\"asset\": {\n" +
                    "\t\t\"version\": \"1.0\",\n" +
                    "\t\t\"tilesetVersion\": \"2020-06-02 12:34:23.374\",\n" +
                    "\t\t\"extras\": {\n" +
                    "\t\t\t\"copyright\": \"**Trial version, Do not use for commercial purpose!** Copyright BimAngle 2017-2020\",\n" +
                    "\t\t\t\"generator\": \"**Trial version, Do not use for commercial purpose!** BimAngle Engine (For Revit) 2020.4.14\",\n" +
                    "\t\t\t\"title\": \"REC-S1P3-S103-INrvt\",\n" +
                    "\t\t\t\"cesium\": {\n" +
                    "\t\t\t\t\"credits\": [{\n" +
                    "\t\t\t\t\t\"html\": \"<font color='#FFFF00'><b>BimAngle Engine: Trial version, Do not use for commercial purpose!</b></font>\",\n" +
                    "\t\t\t\t\t\"showOnScreen\": true\n" +
                    "\t\t\t\t}]\n" +
                    "\t\t\t}\n" +
                    "\t\t}\n" +
                    "\t},\n" +
                    "\t\"geometricError\": 138.444,\n" +
                    "\t\"root\": {\n" +
                    "\t\t\"boundingVolume\": {\n" +
                    "\t\t\t\"box\": [56.227075341349021, 21.874995803759845, 19.350000294380067, 64.647073711124492, 0.0, 0.0, 0.0, 24.644996837780877, 0.0, 0.0, 0.0, 2.2515979088606048]\n" +
                    "\t\t},\n" +
                    "\t\t\"geometricError\": 138.444,\n" +
                    "\t\t\"refine\": \"ADD\",\n" +
                    "\t\t\"content\": {\n" +
                    "\t\t\t\"uri\": \"0/m.cmpt\"\n" +
                    "\t\t},\n" +
                    "\t\t\"children\": [{\n" +
                    "\t\t\t\"boundingVolume\": {\n" +
                    "\t\t\t\t\"box\": [1.5775001378114939, 27.972018146187672, 19.350000901602176, 1.8475001486586007, 0.0, 0.0, 0.0, 6.872020784396037, 0.0, 0.0, 0.0, 2.2515969619273086]\n" +
                    "\t\t\t},\n" +
                    "\t\t\t\"geometricError\": 0.0,\n" +
                    "\t\t\t\"content\": {\n" +
                    "\t\t\t\t\"uri\": \"0/0/m.cmpt\"\n" +
                    "\t\t\t}\n" +
                    "\t\t}, {\n" +
                    "\t\t\t\"boundingVolume\": {\n" +
                    "\t\t\t\t\"box\": [42.976844714499066, 28.948194587032802, 19.350001488118117, 7.2568431866109222, 0.0, 0.0, 0.0, 6.4643025351581063, 0.0, 0.0, 0.0, 2.2515959800782994]\n" +
                    "\t\t\t},\n" +
                    "\t\t\t\"geometricError\": 19.952,\n" +
                    "\t\t\t\"content\": {\n" +
                    "\t\t\t\t\"uri\": \"0/1/m.cmpt\"\n" +
                    "\t\t\t},\n" +
                    "\t\t\t\"children\": [{\n" +
                    "\t\t\t\t\"boundingVolume\": {\n" +
                    "\t\t\t\t\t\"box\": [39.160000899016268, 32.793746678687995, 19.350000515894884, 3.439999371128124, 0.0, 0.0, 0.0, 2.6187504435029147, 0.0, 0.0, 0.0, 2.2515950066629067]\n" +
                    "\t\t\t\t},\n" +
                    "\t\t\t\t\"geometricError\": 9.749,\n" +
                    "\t\t\t\t\"content\": {\n" +
                    "\t\t\t\t\t\"uri\": \"0/1/0/m.cmpt\"\n" +
                    "\t\t\t\t},\n" +
                    "\t\t\t\t\"children\": [{\n" +
                    "\t\t\t\t\t\"boundingVolume\": {\n" +
                    "\t\t\t\t\t\t\"box\": [40.254289932315942, 30.814997939867851, 18.614202428742121, 1.4542903194871997, 0.0, 0.0, 0.0, 0.61499845515871954, 0.0, 0.0, 0.0, 1.5157969195100058]\n" +
                    "\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\"geometricError\": 0.0,\n" +
                    "\t\t\t\t\t\"content\": {\n" +
                    "\t\t\t\t\t\t\"uri\": \"0/1/0/0/m.cmpt\"\n" +
                    "\t\t\t\t\t}\n" +
                    "\t\t\t\t}, {\n" +
                    "\t\t\t\t\t\"boundingVolume\": {\n" +
                    "\t\t\t\t\t\t\"box\": [40.690000551714547, 33.371246277702049, 18.524202293095406, 1.9099997184298445, 0.0, 0.0, 0.0, 2.0412508444888573, 0.0, 0.0, 0.0, 1.4257966670383837]\n" +
                    "\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\"geometricError\": 0.0,\n" +
                    "\t\t\t\t\t\"content\": {\n" +
                    "\t\t\t\t\t\t\"uri\": \"0/1/0/1/m.cmpt\"\n" +
                    "\t\t\t\t\t}\n" +
                    "\t\t\t\t}]\n" +
                    "\t\t\t}, {\n" +
                    "\t\t\t\t\"boundingVolume\": {\n" +
                    "\t\t\t\t\t\"box\": [47.903013854971277, 24.425946506481324, 19.800798232373033, 2.3306740461387108, 0.0, 0.0, 0.0, 1.9420544546066285, 0.0, 0.0, 0.0, 1.8007992358233853]\n" +
                    "\t\t\t\t},\n" +
                    "\t\t\t\t\"geometricError\": 0.0,\n" +
                    "\t\t\t\t\"content\": {\n" +
                    "\t\t\t\t\t\"uri\": \"0/1/1/m.cmpt\"\n" +
                    "\t\t\t\t}\n" +
                    "\t\t\t}]\n" +
                    "\t\t}, {\n" +
                    "\t\t\t\"boundingVolume\": {\n" +
                    "\t\t\t\t\"box\": [41.924999602622393, 37.071245683161685, 19.350001522235733, 8.474999079351619, 0.0, 0.0, 0.0, 1.6987509504058735, 0.0, 0.0, 0.0, 2.2515966810049406]\n" +
                    "\t\t\t},\n" +
                    "\t\t\t\"geometricError\": 17.864,\n" +
                    "\t\t\t\"children\": [{\n" +
                    "\t\t\t\t\"boundingVolume\": {\n" +
                    "\t\t\t\t\t\"box\": [38.025002722147065, 37.071245683161685, 19.350001522235733, 4.575002198876291, 0.0, 0.0, 0.0, 1.6987509504058735, 0.0, 0.0, 0.0, 2.2515966810049406]\n" +
                    "\t\t\t\t},\n" +
                    "\t\t\t\t\"geometricError\": 10.749,\n" +
                    "\t\t\t\t\"content\": {\n" +
                    "\t\t\t\t\t\"uri\": \"0/2/0/m.cmpt\"\n" +
                    "\t\t\t\t},\n" +
                    "\t\t\t\t\"children\": [{\n" +
                    "\t\t\t\t\t\"boundingVolume\": {\n" +
                    "\t\t\t\t\t\t\"box\": [40.800004303684432, 35.714994942586088, 18.14920323659813, 1.8000006173389238, 0.0, 0.0, 0.0, 0.34249999515854057, 0.0, 0.0, 0.0, 1.0507974190612295]\n" +
                    "\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\"geometricError\": 0.0,\n" +
                    "\t\t\t\t\t\"content\": {\n" +
                    "\t\t\t\t\t\t\"uri\": \"0/2/0/0/m.cmpt\"\n" +
                    "\t\t\t\t\t}\n" +
                    "\t\t\t\t}, {\n" +
                    "\t\t\t\t\t\"boundingVolume\": {\n" +
                    "\t\t\t\t\t\t\"box\": [40.4499989191097, 37.854996667462338, 18.549202796082444, 2.0299993720125258, 0.0, 0.0, 0.0, 0.91499996610522061, 0.0, 0.0, 0.0, 1.4507979548516516]\n" +
                    "\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\"geometricError\": 0.0,\n" +
                    "\t\t\t\t\t\"content\": {\n" +
                    "\t\t\t\t\t\t\"uri\": \"0/2/0/1/m.cmpt\"\n" +
                    "\t\t\t\t\t}\n" +
                    "\t\t\t\t}]\n" +
                    "\t\t\t}, {\n" +
                    "\t\t\t\t\"boundingVolume\": {\n" +
                    "\t\t\t\t\t\"box\": [46.070000136028057, 37.078646437446089, 19.350001522235733, 4.3299985459459549, 0.0, 0.0, 0.0, 1.6913501961214692, 0.0, 0.0, 0.0, 2.2515966810049406]\n" +
                    "\t\t\t\t},\n" +
                    "\t\t\t\t\"geometricError\": 0.0,\n" +
                    "\t\t\t\t\"content\": {\n" +
                    "\t\t\t\t\t\"uri\": \"0/2/1/m.cmpt\"\n" +
                    "\t\t\t\t}\n" +
                    "\t\t\t}]\n" +
                    "\t\t}, {\n" +
                    "\t\t\t\"boundingVolume\": {\n" +
                    "\t\t\t\t\"box\": [85.684422140514016, 18.275089933949509, 19.35000014857534, 7.2470135539210787, 0.0, 0.0, 0.0, 4.5449095390807, 0.0, 0.0, 0.0, 2.2515967497768816]\n" +
                    "\t\t\t},\n" +
                    "\t\t\t\"geometricError\": 0.0,\n" +
                    "\t\t\t\"content\": {\n" +
                    "\t\t\t\t\"uri\": \"0/3/m.cmpt\"\n" +
                    "\t\t\t}\n" +
                    "\t\t}, {\n" +
                    "\t\t\t\"boundingVolume\": {\n" +
                    "\t\t\t\t\"box\": [113.98500668042641, 16.52999668441656, 19.350000206761173, 6.8850030862730591, 0.0, 0.0, 0.0, 6.3499990676403435, 0.0, 0.0, 0.0, 2.2515970535338994]\n" +
                    "\t\t\t},\n" +
                    "\t\t\t\"geometricError\": 19.266,\n" +
                    "\t\t\t\"content\": {\n" +
                    "\t\t\t\t\"uri\": \"0/4/m.cmpt\"\n" +
                    "\t\t\t},\n" +
                    "\t\t\t\"children\": [{\n" +
                    "\t\t\t\t\"boundingVolume\": {\n" +
                    "\t\t\t\t\t\"box\": [110.33750369520067, 19.602497142328637, 19.349999232084389, 3.237500101047317, 0.0, 0.0, 0.0, 3.2224996459202213, 0.0, 0.0, 0.0, 2.2515956991950929]\n" +
                    "\t\t\t\t},\n" +
                    "\t\t\t\t\"geometricError\": 0.0,\n" +
                    "\t\t\t\t\"content\": {\n" +
                    "\t\t\t\t\t\"uri\": \"0/4/0/m.cmpt\"\n" +
                    "\t\t\t\t}\n" +
                    "\t\t\t}, {\n" +
                    "\t\t\t\t\"boundingVolume\": {\n" +
                    "\t\t\t\t\t\"box\": [116.69500408940746, 19.389996177813998, 19.350000412397193, 4.1750056772920061, 0.0, 0.0, 0.0, 3.489999574242904, 0.0, 0.0, 0.0, 2.2515968478978809]\n" +
                    "\t\t\t\t},\n" +
                    "\t\t\t\t\"geometricError\": 11.778,\n" +
                    "\t\t\t\t\"content\": {\n" +
                    "\t\t\t\t\t\"uri\": \"0/4/1/m.cmpt\"\n" +
                    "\t\t\t\t},\n" +
                    "\t\t\t\t\"children\": [{\n" +
                    "\t\t\t\t\t\"boundingVolume\": {\n" +
                    "\t\t\t\t\t\t\"box\": [114.4650052965053, 17.359997057510007, 18.907879606131772, 0.910000279801352, 0.0, 0.0, 0.0, 0.7600001110667236, 0.0, 0.0, 0.0, 0.90452440803960066]\n" +
                    "\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\"geometricError\": 0.0,\n" +
                    "\t\t\t\t\t\"content\": {\n" +
                    "\t\t\t\t\t\t\"uri\": \"0/4/1/0/i0.i3dm\"\n" +
                    "\t\t\t\t\t}\n" +
                    "\t\t\t\t}, {\n" +
                    "\t\t\t\t\t\"boundingVolume\": {\n" +
                    "\t\t\t\t\t\t\"box\": [114.57499858399751, 21.114997786611752, 18.614201945795436, 2.0550001718820567, 0.0, 0.0, 0.0, 1.7099990016371081, 0.0, 0.0, 0.0, 1.5157968895586986]\n" +
                    "\t\t\t\t\t},\n" +
                    "\t\t\t\t\t\"geometricError\": 0.0,\n" +
                    "\t\t\t\t\t\"content\": {\n" +
                    "\t\t\t\t\t\t\"uri\": \"0/4/1/1/m.cmpt\"\n" +
                    "\t\t\t\t\t}\n" +
                    "\t\t\t\t}]\n" +
                    "\t\t\t}]\n" +
                    "\t\t}, {\n" +
                    "\t\t\t\"boundingVolume\": {\n" +
                    "\t\t\t\t\"box\": [113.54383360570951, 36.759806661029046, 19.350001411715159, 6.4438207092453439, 0.0, 0.0, 0.0, 2.010189972542225, 0.0, 0.0, 0.0, 2.2515967915255146]\n" +
                    "\t\t\t},\n" +
                    "\t\t\t\"geometricError\": 0.0,\n" +
                    "\t\t\t\"content\": {\n" +
                    "\t\t\t\t\"uri\": \"0/5/m.cmpt\"\n" +
                    "\t\t\t}\n" +
                    "\t\t}, {\n" +
                    "\t\t\t\"boundingVolume\": {\n" +
                    "\t\t\t\t\"box\": [37.072705031155039, 34.599995546945962, 19.800798148063045, 0.15310461004651188, 0.0, 0.0, 0.0, 2.1553985926603438, 0.0, 0.0, 0.0, 1.8007976144032511]\n" +
                    "\t\t\t},\n" +
                    "\t\t\t\"geometricError\": 5.626,\n" +
                    "\t\t\t\"refine\": \"ADD\",\n" +
                    "\t\t\t\"content\": {\n" +
                    "\t\t\t\t\"uri\": \"0/6/m.cmpt\"\n" +
                    "\t\t\t}\n" +
                    "\t\t}],\n" +
                    "\t\t\"transform\": [-0.91662232846732, -0.39975430823838365, 0.0, 0.0, 0.15192183112032723, -0.34835132409252745, 0.92497087101812558, 0.0, -0.369761090684506, 0.84784895355707934, 0.38003800832018148, 0.0, -2359527.8382386481, 5410312.926208768, 2408872.5488892803, 1.0]\n" +
                    "\t},\n" +
                    "\t\"extras\": {\n" +
                    "\t\t\"BIMANGLE_georeferencing\": {\n" +
                    "\t\t\t\"ver\": 1.0,\n" +
                    "\t\t\t\"longitude\": 113.56282,\n" +
                    "\t\t\t\"latitude\": 22.336037,\n" +
                    "\t\t\t\"height\": 0.0,\n" +
                    "\t\t\t\"rotation\": 0.0\n" +
                    "\t\t}\n" +
                    "\t}\n" +
                    "}";

            // 将入参 json 转换为 json 对象
            JSONObject j3 = JSON.parseObject(json);
            List<String> mid = new ArrayList<>();

            // 替换(私有方法)
            /**
             * @param json 需要处理的json数据 - JSONObject
             * @param k key
             * @param list 空 list
             * */
            getJSONValue(j3, "uri", mid);

            // mid.stream().forEach(System.out::println);

            System.out.println("替换数组------：" + mid);
            // 直接全局匹配替换String的value值
            for (int i = 0; i < mid.size(); i++) {
                System.out.println("s匹配:" + mid.get(i));


            }
            StringBuffer stringBuffer = new StringBuffer();
            // StringBuffer replace = stringBuffer.replace();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("文件异常");
        }
    }


}

