package com.jinhaoplus.oj.dao;

import java.util.List;

import com.jinhaoplus.oj.domain.Pair;


public interface PairDao {
	public Pair getPairByBitCode(String bitCode);
	public List<Pair> getPairs();
	public void updatePairByBitCode(Pair pair);
}
