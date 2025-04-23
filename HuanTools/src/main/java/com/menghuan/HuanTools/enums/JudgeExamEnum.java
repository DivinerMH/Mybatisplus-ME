package com.menghuan.HuanTools.enums;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 考评内容
 *
 * @author menghuan
 * @date 2025-02-25 17:32:11
 */
@Getter
@AllArgsConstructor
public enum JudgeExamEnum {

    EXAM_ONE("未按规定的时间到达评审现场", new BigDecimal("5.0")),
    EXAM_TWO("在评审现场从事与评审活动无关的事情影响评审工作秩序", new BigDecimal("5.0")),
    EXAM_THREE("评审工作未结束，无正当理由提前离开评审现场", new BigDecimal("5.0")),
    EXAM_FOUR("在评审现场征询采购人的倾向性意见", new BigDecimal("15.0")),
    EXAM_FIVE("无故不按规定提交评审意见", new BigDecimal("5.0")),
    EXAM_SIX("记录、复制或带走评审相关资料", new BigDecimal("10.0")),
    EXAM_SEVEN("对参加评审的专业不熟悉，市场行情不了解,专业技能不能满足评审工作要求", new BigDecimal("10.0")),
    EXAM_EIGHT("在评审现场发表个人倾向性意见", new BigDecimal("15.0")),
    EXAM_NINE("对需要专业判断的主观评审因素协商评分", new BigDecimal("15.0")),
    EXAM_TEN("未按照采购文件进行评审", new BigDecimal("15.0"));

    private String examContent;
    private BigDecimal examScore;

    public static JudgeExamEnum examContentOf(String examContent) {
        if (Objects.isNull(examContent)) {
            return null;
        }
        return Arrays.stream(JudgeExamEnum.values()).filter(item -> item.examContent.equals(examContent)).findAny()
            .orElse(null);
    }

    public static JudgeExamEnum examScoreOf(Double examScore) {
        if (Objects.isNull(examScore)) {
            return null;
        }
        return Arrays.stream(JudgeExamEnum.values()).filter(item -> item.examScore.equals(examScore)).findAny()
            .orElse(null);
    }

    public static List<String> examContentList =
        Arrays.stream(JudgeExamEnum.values()).map(JudgeExamEnum::getExamContent).collect(Collectors.toList());

    public static List<BigDecimal> examScoreList =
        Arrays.stream(JudgeExamEnum.values()).map(JudgeExamEnum::getExamScore).collect(Collectors.toList());

    public static List<Map<String, Object>> getEnumToMap() {
        return Arrays.stream(JudgeExamEnum.values()).map(e -> new HashMap<String, Object>() {
            {
                put("examContent", e.getExamContent());
                put("examScore", e.getExamScore());
            }
        }).collect(Collectors.toList());
    }
}
