package fr.leben.rabbitapi;

/**
 * 
 * This file is part of Rabbit, licensed under the MIT License (MIT).
 *
 * Copyright (c) LebCorp/RabbitTeam
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

public class WorldCreator {

	private String name;
	private long seed;
	private WorldType type;

	public WorldCreator() {
	}

	public WorldCreator(String name) {
		this.name = name;
	}

	public WorldCreator name(String name) {
		this.name = name;
		return this;
	}
	
	public WorldCreator seed(long seed) {
		this.seed = seed;
		return this;
	}
	
	public WorldCreator type(WorldType type) {
		this.type = type;
		return this;
	}
	
	
	public String name() {
		return name;
	}

	public long seed() {
		return seed;
	}

	public WorldType type() {
		return type;
	}

	public World createWorld() {
		return Rabbit.createWorld(this);
	}
}
