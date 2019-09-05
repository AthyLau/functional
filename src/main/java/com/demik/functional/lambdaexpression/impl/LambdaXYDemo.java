package com.demik.functional.lambdaexpression.impl;

import com.demik.functional.lambdaexpression.inf.LambdaXY;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/9/5 10:24 AM
 * @since JDK 1.8
 */
public class LambdaXYDemo implements LambdaXY<Long> {

    @Override
    public Long apply(Long x, Long y) {
        return x + y;
    }

}
