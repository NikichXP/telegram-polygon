package com.polygon.util;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class Async<T> {

	private Async(Supplier<T> supplier) {
		this.result = CompletableFuture.supplyAsync(supplier);
	}

	private CompletableFuture<T> result;

	public T get() {
		try {
			return result.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static <T> Async<T> of (Supplier<T> supplier) {
		return new Async<T>(supplier);
	}

	public static CompletableFuture async(Runnable task) {
		try {
			return CompletableFuture.runAsync(task);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static <T> CompletableFuture<T> async (Supplier<T> supplier) {
		try {
			return CompletableFuture.supplyAsync(supplier);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
