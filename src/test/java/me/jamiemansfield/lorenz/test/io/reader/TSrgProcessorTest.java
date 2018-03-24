/*
 * This file is part of Lorenz, licensed under the MIT License (MIT).
 *
 * Copyright (c) Jamie Mansfield <https://www.jamierocks.uk/>
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

package me.jamiemansfield.lorenz.test.io.reader;

import me.jamiemansfield.lorenz.MappingSet;
import me.jamiemansfield.lorenz.io.reader.TSrgProcessor;

import java.io.IOException;

public class TSrgProcessorTest extends ProcessorTest {

    private static MappingSet createMappings() {
        final TSrgProcessor parser = new TSrgProcessor();

        // Feed in mappings
        try {
            parser.processLine("# yu uk/jamierocks/Comment");
            parser.processLine("uih uk/jamierocks/CommentTest # op uk/jr/Operator");
            parser.processLine("ght uk/jamierocks/Test");
            parser.processLine("\trft log");
            parser.processLine("\thyuip (I)Z isEven");
            parser.processLine("ght$ds uk/jamierocks/Test$Example");
            parser.processLine("\tjuh server");
            parser.processLine("\thyuip (I)Z isOdd");
            parser.processLine("ght$ds$bg uk/jamierocks/Test$Example$Inner");
        }
        catch (final IOException ignored) {
        }

        return parser.getResult();
    }

    public TSrgProcessorTest() {
        super(createMappings());
    }

}