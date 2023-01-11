package com.gagefulwood.genericsproject.classes;

interface IntUserInputRetriever <T> {
	public abstract T produceOutputOnIntUserInput(int selection) throws IllegalArgumentException;
}
