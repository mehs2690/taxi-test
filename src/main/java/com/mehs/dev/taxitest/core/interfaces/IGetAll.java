package com.mehs.dev.taxitest.core.interfaces;

import java.util.List;

public interface IGetAll<Q, O> {
	List<O> getAll(Q query);
}
