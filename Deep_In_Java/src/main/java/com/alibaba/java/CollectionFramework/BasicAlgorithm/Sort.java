package com.alibaba.java.CollectionFramework.BasicAlgorithm;

import org.apache.poi.ss.formula.functions.T;

/**
 * 本议题主要讨论java中对通用算法对实现，
 * 理论部分：
 * 1：稳定性排序算法
 * 2：非稳定性排序算法
 * ps：扑克牌，拍数字也排花色为稳定性排序算法，反之亦然
 *
 *
 * 排序接口
 *
 * 原地（在地）排序-In-Place 不会产生额外的空间去排序
 */
public interface Sort<T extends Comparable<T> > {
  public abstract void Sort(T[] values);
}
