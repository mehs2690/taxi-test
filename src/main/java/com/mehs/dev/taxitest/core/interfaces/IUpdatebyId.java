package com.mehs.dev.taxitest.core.interfaces;

public interface IUpdatebyId<I, Q, O> {
	O updatebyId(I id, Q query);
}
