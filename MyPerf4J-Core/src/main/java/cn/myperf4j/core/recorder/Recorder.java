package cn.myperf4j.core.recorder;

import cn.myperf4j.base.buffer.IntBuf;

/**
 * Created by LinShunkang on 2018/3/13
 */
public abstract class Recorder {

    private final int methodTagId;

    public Recorder(int methodTagId) {
        this.methodTagId = methodTagId;
    }

    public int getMethodTagId() {
        return methodTagId;
    }

    public abstract boolean hasRecord();

    public abstract void recordTime(long startNanoTime, long endNanoTime);

    /**
     * 为了节省内存的使用，利用 IntBuf 作为返回结果
     * <p>
     * 注意：timeCost 的单位是 0.1ms
     *
     * @param intBuf : intBuf.capacity为effectiveRecordCount的两倍!!! 其中，第 0 位存 timeCost，第 1 位存 count，第 2 位存t imeCost，第 3 位存 count，以此类推
     */
    public abstract int fillSortedRecords(IntBuf intBuf);

    /**
     * 获取有效的记录的个数
     */
    public abstract int getDiffCount();

    public abstract void resetRecord();

}
