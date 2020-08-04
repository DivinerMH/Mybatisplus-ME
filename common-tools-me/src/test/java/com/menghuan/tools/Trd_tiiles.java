package com.menghuan.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author:menghuan
 * @Date:2020/6/16 15:14
 */
public class Trd_tiiles {

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
            // System.out.println("文件异常");
        }
    }

    /**
     * @param json 需要处理的json数据 - JSONObject
     * @param k    key
     * @param list 空 list
     * @return list
     */
    public static List<String> getJSONValue(JSONObject json, String k, List<String> list) {
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

                /*Map<String, Object> map = Maps.newHashMap();
                map.put("cat/meng1.jpg", 1);
                map.put("cat/red/blue/huan1.jpg", 2);
                map.put("1/0/1/m.cmpt", 3);*/

                //是字符串
                list.add(json.get(j).toString());
                String mh = json.get(j).toString();
                System.out.println("处理前-需要替换的路径：" + mh);

               /* String substring = mh.substring(mh.indexOf("/") + 1);
                System.out.println("处理后-需要替换的路径：" + substring);

                // key
                for(String key : map.keySet()){

                    if (key.equals(substring)) {
                        System.out.println("我是匹配的value" + map.get(key));
                        map.put(key, "可怕的云服务");
                    }
                }*/
            }
        }
        // System.out.println("list:" + list);
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

    public static boolean isJSONObj(Object json) {
        return json instanceof JSONObject;
    }

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

    @Test
    public void terAAA() {
        String s = "{\"0/2/1/m.cmpt\": \"eb1263b9cae94a90af1a5fadc0cc6641.cmpt\",\n" +
                "        \"0/1/0/0/m.cmpt\": \"681c6e1ee0864adcb3f99db2e1592678.cmpt\",\n" +
                "        \"bucketName\": \"iot\",\n" +
                "        \"0/2/0/m.cmpt\": \"f4f5368b11f344b585b88290cd1dc7fd.cmpt\",\n" +
                "        \"textures/102_5add8536225f5c9586591a6c791ba325_x.webp\": \"39ebc119e350493e9c641f1877318fb6.webp\",\n" +
                "        \"0/0/m.cmpt\": \"bbe71f5e716c4810a7be27c9812eec71.cmpt\",\n" +
                "        \"0/1/0/1/m.cmpt\": \"6f4f3e21881647709e275185faa08a8f.cmpt\",\n" +
                "        \"0/1/m.cmpt\": \"df460c20a4f04cee83651a4332766d91.cmpt\",\n" +
                "        \"0/1/1/m.cmpt\": \"8fc1bded75e947ea973850baadf050bc.cmpt\",\n" +
                "        \"instances/2.glb\": \"aef72751bb44477cb16e6fe45c9b6a8d.glb\",\n" +
                "        \"tileset.json\": \"{\\\"asset\\\":{\\\"version\\\":\\\"1.0\\\",\\\"tilesetVersion\\\":\\\"2020-06-02 12:34:23.374\\\",\\\"extras\\\":{\\\"copyright\\\":\\\"**Trial version, Do not use for commercial purpose!** Copyright BimAngle 2017-2020\\\",\\\"generator\\\":\\\"**Trial version, Do not use for commercial purpose!** BimAngle Engine (For Revit) 2020.4.14\\\",\\\"title\\\":\\\"REC-S1P3-S103-INrvt\\\",\\\"cesium\\\":{\\\"credits\\\":[{\\\"html\\\":\\\"<font color='#FFFF00'><b>BimAngle Engine: Trial version, Do not use for commercial purpose!</b></font>\\\",\\\"showOnScreen\\\":true}]}}},\\\"geometricError\\\":138.444,\\\"root\\\":{\\\"boundingVolume\\\":{\\\"box\\\":[56.227075341349021,21.874995803759845,19.350000294380067,64.647073711124492,0.0,0.0,0.0,24.644996837780877,0.0,0.0,0.0,2.2515979088606048]},\\\"geometricError\\\":138.444,\\\"refine\\\":\\\"ADD\\\",\\\"content\\\":{\\\"uri\\\":\\\"0/m.cmpt\\\"},\\\"children\\\":[{\\\"boundingVolume\\\":{\\\"box\\\":[1.5775001378114939,27.972018146187672,19.350000901602176,1.8475001486586007,0.0,0.0,0.0,6.872020784396037,0.0,0.0,0.0,2.2515969619273086]},\\\"geometricError\\\":0.0,\\\"content\\\":{\\\"uri\\\":\\\"0/0/m.cmpt\\\"}},{\\\"boundingVolume\\\":{\\\"box\\\":[42.976844714499066,28.948194587032802,19.350001488118117,7.2568431866109222,0.0,0.0,0.0,6.4643025351581063,0.0,0.0,0.0,2.2515959800782994]},\\\"geometricError\\\":19.952,\\\"content\\\":{\\\"uri\\\":\\\"0/1/m.cmpt\\\"},\\\"children\\\":[{\\\"boundingVolume\\\":{\\\"box\\\":[39.160000899016268,32.793746678687995,19.350000515894884,3.439999371128124,0.0,0.0,0.0,2.6187504435029147,0.0,0.0,0.0,2.2515950066629067]},\\\"geometricError\\\":9.749,\\\"content\\\":{\\\"uri\\\":\\\"0/1/0/m.cmpt\\\"},\\\"children\\\":[{\\\"boundingVolume\\\":{\\\"box\\\":[40.254289932315942,30.814997939867851,18.614202428742121,1.4542903194871997,0.0,0.0,0.0,0.61499845515871954,0.0,0.0,0.0,1.5157969195100058]},\\\"geometricError\\\":0.0,\\\"content\\\":{\\\"uri\\\":\\\"0/1/0/0/m.cmpt\\\"}},{\\\"boundingVolume\\\":{\\\"box\\\":[40.690000551714547,33.371246277702049,18.524202293095406,1.9099997184298445,0.0,0.0,0.0,2.0412508444888573,0.0,0.0,0.0,1.4257966670383837]},\\\"geometricError\\\":0.0,\\\"content\\\":{\\\"uri\\\":\\\"0/1/0/1/m.cmpt\\\"}}]},{\\\"boundingVolume\\\":{\\\"box\\\":[47.903013854971277,24.425946506481324,19.800798232373033,2.3306740461387108,0.0,0.0,0.0,1.9420544546066285,0.0,0.0,0.0,1.8007992358233853]},\\\"geometricError\\\":0.0,\\\"content\\\":{\\\"uri\\\":\\\"0/1/1/m.cmpt\\\"}}]},{\\\"boundingVolume\\\":{\\\"box\\\":[41.924999602622393,37.071245683161685,19.350001522235733,8.474999079351619,0.0,0.0,0.0,1.6987509504058735,0.0,0.0,0.0,2.2515966810049406]},\\\"geometricError\\\":17.864,\\\"children\\\":[{\\\"boundingVolume\\\":{\\\"box\\\":[38.025002722147065,37.071245683161685,19.350001522235733,4.575002198876291,0.0,0.0,0.0,1.6987509504058735,0.0,0.0,0.0,2.2515966810049406]},\\\"geometricError\\\":10.749,\\\"content\\\":{\\\"uri\\\":\\\"0/2/0/m.cmpt\\\"},\\\"children\\\":[{\\\"boundingVolume\\\":{\\\"box\\\":[40.800004303684432,35.714994942586088,18.14920323659813,1.8000006173389238,0.0,0.0,0.0,0.34249999515854057,0.0,0.0,0.0,1.0507974190612295]},\\\"geometricError\\\":0.0,\\\"content\\\":{\\\"uri\\\":\\\"0/2/0/0/m.cmpt\\\"}},{\\\"boundingVolume\\\":{\\\"box\\\":[40.4499989191097,37.854996667462338,18.549202796082444,2.0299993720125258,0.0,0.0,0.0,0.91499996610522061,0.0,0.0,0.0,1.4507979548516516]},\\\"geometricError\\\":0.0,\\\"content\\\":{\\\"uri\\\":\\\"0/2/0/1/m.cmpt\\\"}}]},{\\\"boundingVolume\\\":{\\\"box\\\":[46.070000136028057,37.078646437446089,19.350001522235733,4.3299985459459549,0.0,0.0,0.0,1.6913501961214692,0.0,0.0,0.0,2.2515966810049406]},\\\"geometricError\\\":0.0,\\\"content\\\":{\\\"uri\\\":\\\"0/2/1/m.cmpt\\\"}}]},{\\\"boundingVolume\\\":{\\\"box\\\":[85.684422140514016,18.275089933949509,19.35000014857534,7.2470135539210787,0.0,0.0,0.0,4.5449095390807,0.0,0.0,0.0,2.2515967497768816]},\\\"geometricError\\\":0.0,\\\"content\\\":{\\\"uri\\\":\\\"0/3/m.cmpt\\\"}},{\\\"boundingVolume\\\":{\\\"box\\\":[113.98500668042641,16.52999668441656,19.350000206761173,6.8850030862730591,0.0,0.0,0.0,6.3499990676403435,0.0,0.0,0.0,2.2515970535338994]},\\\"geometricError\\\":19.266,\\\"content\\\":{\\\"uri\\\":\\\"0/4/m.cmpt\\\"},\\\"children\\\":[{\\\"boundingVolume\\\":{\\\"box\\\":[110.33750369520067,19.602497142328637,19.349999232084389,3.237500101047317,0.0,0.0,0.0,3.2224996459202213,0.0,0.0,0.0,2.2515956991950929]},\\\"geometricError\\\":0.0,\\\"content\\\":{\\\"uri\\\":\\\"0/4/0/m.cmpt\\\"}},{\\\"boundingVolume\\\":{\\\"box\\\":[116.69500408940746,19.389996177813998,19.350000412397193,4.1750056772920061,0.0,0.0,0.0,3.489999574242904,0.0,0.0,0.0,2.2515968478978809]},\\\"geometricError\\\":11.778,\\\"content\\\":{\\\"uri\\\":\\\"0/4/1/m.cmpt\\\"},\\\"children\\\":[{\\\"boundingVolume\\\":{\\\"box\\\":[114.4650052965053,17.359997057510007,18.907879606131772,0.910000279801352,0.0,0.0,0.0,0.7600001110667236,0.0,0.0,0.0,0.90452440803960066]},\\\"geometricError\\\":0.0,\\\"content\\\":{\\\"uri\\\":\\\"0/4/1/0/i0.i3dm\\\"}},{\\\"boundingVolume\\\":{\\\"box\\\":[114.57499858399751,21.114997786611752,18.614201945795436,2.0550001718820567,0.0,0.0,0.0,1.7099990016371081,0.0,0.0,0.0,1.5157968895586986]},\\\"geometricError\\\":0.0,\\\"content\\\":{\\\"uri\\\":\\\"0/4/1/1/m.cmpt\\\"}}]}]},{\\\"boundingVolume\\\":{\\\"box\\\":[113.54383360570951,36.759806661029046,19.350001411715159,6.4438207092453439,0.0,0.0,0.0,2.010189972542225,0.0,0.0,0.0,2.2515967915255146]},\\\"geometricError\\\":0.0,\\\"content\\\":{\\\"uri\\\":\\\"0/5/m.cmpt\\\"}},{\\\"boundingVolume\\\":{\\\"box\\\":[37.072705031155039,34.599995546945962,19.800798148063045,0.15310461004651188,0.0,0.0,0.0,2.1553985926603438,0.0,0.0,0.0,1.8007976144032511]},\\\"geometricError\\\":5.626,\\\"refine\\\":\\\"ADD\\\",\\\"content\\\":{\\\"uri\\\":\\\"0/6/m.cmpt\\\"}}],\\\"transform\\\":[-0.91662232846732,-0.39975430823838365,0.0,0.0,0.15192183112032723,-0.34835132409252745,0.92497087101812558,0.0,-0.369761090684506,0.84784895355707934,0.38003800832018148,0.0,-2359527.8382386481,5410312.926208768,2408872.5488892803,1.0]},\\\"extras\\\":{\\\"BIMANGLE_georeferencing\\\":{\\\"ver\\\":1.0,\\\"longitude\\\":113.56282,\\\"latitude\\\":22.336037,\\\"height\\\":0.0,\\\"rotation\\\":0.0}}}\",\n" +
                "        \"0/1/0/m.cmpt\": \"78d5b75737574b3885a1f511b63b8c50.cmpt\",\n" +
                "        \"0/2/0/0/m.cmpt\": \"e25b530c8e914e8c83195eb27d88133f.cmpt\",\n" +
                "        \"0/2/0/1/m.cmpt\": \"bc3c925686764871911bcf2632049900.cmpt\",\n" +
                "        \"textures/102_5add8536225f5c9586591a6c791ba325_x.png\": \"8ecc4de9a4fe425da7db8e2043f2321a.png\",\n" +
                "        \"0/m.cmpt\": \"70574f6b320c4f048d93b08cdce44e46.cmpt\",\n" +
                "        \"instances/1.glb\": \"471024ea74d44c2d99a934bbc3cd4bf2.glb\",\n" +
                "        \"instances/3.glb\": \"a72b970d45d7413ea06d8425dc34826a.glb\",\n" +
                "        \"textures/chipboard_f8a58ea8481e947ea30cd7ba7a36cd78.png\": \"f47659a8e6114efe8bc41f4af58842c2.png\"}";

        // 将入参 json 转换为 json 对象
        JSONObject j6 = JSON.parseObject(s);

        Object remove = j6.remove("tileset.json");
        System.out.println("remove:" + remove);
        System.out.println("j6:" + j6);
        // Map<String, String> map = JSON.parseObject(j6.toJSONString(), Map.class);

        List<String> mid = new ArrayList<>();
        getJSONValue(JSON.parseObject(remove.toString()), "uri", mid);

        StringBuilder stringBuilder = new StringBuilder(remove.toString());

        for (int i = 0; i < mid.size();i++) {
            if (s.contains(mid.get(i)) && j6.getString(mid.get(i)) != null) {
                boolean contains = s.contains(mid.get(i));
                System.out.println("contains:" + contains);
                System.out.println("j6.getString(s1):" + j6.getString(mid.get(i)));
                System.out.println("s1:" + mid.get(i));
                // String replace = stringRessult.replace(mid.get(i), j6.getString(mid.get(i)));
                // System.out.println("replace:" + replace);
                int i1 = stringBuilder.indexOf(mid.get(i));
                int length = mid.get(i).length();
                int i2 = i1 + length;

                // int i2 = stringBuilder.lastIndexOf(mid.get(i));
                System.out.println("i1:" + i1);
                System.out.println("i2:" + i2);
                stringBuilder.replace(i1,i2,j6.getString(mid.get(i)));
                // System.out.println("stringBuilder:" + stringBuilder);


            }

        }
        System.out.println("stringBuilder:-------------------" + stringBuilder);

        /*String s2 = remove.toString();
        String replace = replace(s2, mid, j6);
        System.out.println(replace);*/

    }

    // 递归修改new字符串
    /*public static String replace(String str, List<String> mid, JSONObject json) {
        for (int i = 0; i < mid.size();i++) {
            if (str.contains(mid.get(i)) && json.getString(mid.get(i)) != null) {
                boolean contains = str.contains(mid.get(i));
                System.out.println("contains:" + contains);
                System.out.println("j6.getString(s1):" + json.getString(mid.get(i)));
                System.out.println("s1:" + mid.get(i));
                String replace = str.replace(mid.get(i), json.getString(mid.get(i)));
                // System.out.println("replace:" + replace);
            }
        }
        return replace;
    }*/

    // 递归修改new字符串
    /*public static String replace(String str, List<String> list, JSONObject json) {
        // 数组包含所有需要惊醒替换的key
        for (String string1 : list) {
            if (str.contains(string1) && json.getString(string1) != null) {
                String s2 = str.replace(string1, json.getString(string1));
                // 递归
                replace(s2, list, json);
            }
        }
      return s2;
    }*/

    //递归替换，将母字符串的目标字符串，替换成指定字符串
    public static String replaceAll(String parent, String targetEle, String replaceEle) {

        //当目标元素不存在时，返回母字符串
        if (parent.indexOf(targetEle) == -1) {

            return parent;
        } else {                    //目标元素存在时，采用截取的方式进行递归
            //获取目标元素开始下标
            int beginIndex = parent.indexOf(targetEle);
            //获取目标元素结束位置的下一位置下标
            int endIndex = beginIndex + targetEle.length();

            //采用递归的方法，截取目标元素在parent中的前面字符串 + 替换字符串 + 目标元素在parent中的后面字符串递归
            //注意：substring()方法，当有两个参数时，后者所表示下标元素取不到
            String sRes = parent.substring(0, beginIndex) + replaceEle +
                    replaceAll(parent.substring(endIndex), targetEle, replaceEle);
            return sRes;
        }
    }



    /**
     * 转义json字符串里面的value的特殊字符，key不用管
     *
     * @param jsonStr
     * @return 返回替换后的字符串
     */
    public static String replaceJsonValue(String jsonStr) {
        JSONObject obj = JSON.parseObject(jsonStr);
        replaceValue(obj);
        return obj.toJSONString();
    }

    /**
     * 递归转义value的值，目前是将所有的value的结尾都添加一个“$”，具体实现是，根据具体的需求来。
     *
     * @param obj
     */
    private static void replaceValue(JSONObject obj) {
        Set<Map.Entry<String, Object>> keys = obj.entrySet();
        keys.forEach(key -> {
            Object value = obj.get(key.getKey());
            if (value instanceof JSONObject) { //如果还是JSONObject，继续递归遍历
                replaceValue((JSONObject) value);
            } else if (value instanceof String) {//如果是String（这里没有处理其他类型，如int，double等），表示为具体的value值
                obj.put(key.getKey(), value + "$");
            }
        });
    }

}
