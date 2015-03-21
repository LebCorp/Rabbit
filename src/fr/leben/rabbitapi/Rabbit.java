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

import java.util.logging.Logger;

import fr.leben.rabbit.RabbitServer;

public class Rabbit {

	public static Server SERVER = new RabbitServer();
	
	public static Rabbit INSTANCE = new Rabbit();
	
	
	public static Server getServer() {
		return SERVER;
	}
	
	public static World createWorld(WorldCreator creator) {
		return getServer().createWorld(creator);
	}
	
	public static Logger getLogger() {
		return getServer().getLogger();
	}
	
	public static void start(String... args) {
		getServer().start(args);
	}
	
	public static void shutdown() {
		getServer().shutdown();
	}
	
	public static void main(String[] args) {
		Rabbit.start(args);
	}
} 
