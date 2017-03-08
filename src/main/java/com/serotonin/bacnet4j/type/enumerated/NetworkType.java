/*
 * ============================================================================
 * GNU General Public License
 * ============================================================================
 *
 * Copyright (C) 2015 Infinite Automation Software. All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * When signing a commercial license with Infinite Automation Software,
 * the following extension to GPL is made. A special exception to the GPL is
 * included to allow you to distribute a combined work that includes BAcnet4J
 * without being obliged to provide the source code for any proprietary components.
 *
 * See www.infiniteautomation.com for commercial license options.
 *
 * @author Matthew Lohbihler
 */
package com.serotonin.bacnet4j.type.enumerated;

import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Map;

import com.serotonin.bacnet4j.type.primitive.Enumerated;
import com.serotonin.bacnet4j.util.sero.ByteQueue;

public class NetworkType extends Enumerated {
    public static final NetworkType ethernet = new NetworkType(0);
    public static final NetworkType arcnet = new NetworkType(1);
    public static final NetworkType mstp = new NetworkType(2);
    public static final NetworkType ptp = new NetworkType(3);
    public static final NetworkType lontalk = new NetworkType(4);
    public static final NetworkType ipv4 = new NetworkType(5);
    public static final NetworkType zigbee = new NetworkType(6);
    public static final NetworkType virtual = new NetworkType(7);
    public static final NetworkType ipv6 = new NetworkType(9);
    public static final NetworkType serial = new NetworkType(10);

    private static final Map<Integer, Enumerated> idMap = new HashMap<>();
    private static final Map<String, Enumerated> nameMap = new HashMap<>();
    private static final Map<Integer, String> prettyMap = new HashMap<>();

    static {
        Enumerated.init(MethodHandles.lookup().lookupClass(), idMap, nameMap, prettyMap);
    }

    public static NetworkType forId(final int id) {
        NetworkType e = (NetworkType) idMap.get(id);
        if (e == null)
            e = new NetworkType(id);
        return e;
    }

    public static String nameForId(final int id) {
        return prettyMap.get(id);
    }

    public static NetworkType forName(final String name) {
        return (NetworkType) Enumerated.forName(nameMap, name);
    }

    public static int size() {
        return idMap.size();
    }

    private NetworkType(final int value) {
        super(value);
    }

    public NetworkType(final ByteQueue queue) {
        super(queue);
    }

    @Override
    public String toString() {
        return prettyMap.get(intValue());
    }
}