/*-
 * SPDX-License-Identifier: BSD-2-Clause
 *
 * Copyright (c) 2012, Apps4Av Inc. (apps4av.com)
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice unmodified, this list of conditions, and the following
 *    disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.ds.avare.cap;

import android.graphics.Rect;

import com.ds.avare.position.Coordinate;

/**
 * Represents a model of the CAP grid system for a particular sectional chart.
 * 
 * @author postalservice14, zkhan
 *
 */
public class Chart {
	
	/**
	 * Sectional identifier.
	 */
	private String mIdentifier;
	
	/**
	 * Rectangular region this chart spans.
	 */
	private Rect mRect;
	
	/**
	 * This will init the chart class
	 * @param identifier Sectional identifier
	 * @param northWestLimit
	 * @param southEastLimit
	 */
	public Chart(String identifier, Coordinate northWestLimit, Coordinate southEastLimit) {
		mIdentifier = identifier;
		// Graphics rect increases values in x,y down and to right, but latitude decreases down hence negative sign
		mRect = new Rect(
				makeCapCoordinate(northWestLimit.getLongitude()),
				makeCapCoordinate(-northWestLimit.getLatitude()),
				makeCapCoordinate(southEastLimit.getLongitude()),
				makeCapCoordinate(-southEastLimit.getLatitude()));
	}

	/**
	 * 
	 * @return Sectional identifier
	 */
	public String getIdentifier() {
		return mIdentifier;
	}

	/**
	 * 
	 * @return Rectangular region this chart spans
	 */
	public Rect getRect() {
		return mRect;
	}
	
	/**
	 * 
	 * @return
	 */
	public static int makeCapCoordinate(double coord) {
		// Everything in CAP works in 0.25 or 4 multiples
		return (int)Math.round(coord / CapChartFetcher.GRID_SIZE);
	}
}