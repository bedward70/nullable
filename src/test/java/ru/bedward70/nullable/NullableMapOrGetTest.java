/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2019 Eduard Balovnev (bedward70)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package ru.bedward70.nullable;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * MapOrGet test cases for {@link Nullable}.
 * @since 0.01
 * @checkstyle JavadocMethodCheck (500 lines)
 * @checkstyle LocalFinalVariableNameCheck (500 lines)
 */
public final class NullableMapOrGetTest {

    @Test
    public void testForNullAlternative() {
        final String alternativeString = "Alternative NullAlternative";
        final AtomicInteger countUseElse = new AtomicInteger();
        final Supplier<String> supplier = () -> {
            countUseElse.incrementAndGet();
            return alternativeString;
        };
        final Nullable<String> n = new Nullable<>(null);
        final Nullable<String> result = n.mapOrGet(supplier);
        Assertions.assertEquals(
            1,
            countUseElse.get(),
            "Testing true map and consumer for null alternative"
        );
        Assertions.assertEquals(
            alternativeString,
            result.get(),
            "Testing result for non alternative"
        );
    }

    @Test
    public void testForNonNullAlternative() {
        final String original = "Original NonNullAlternative";
        final String alternativeString = "Alternative NonNullAlternative";
        final AtomicInteger countUseElse = new AtomicInteger();
        final Supplier<String> supplier = () -> {
            countUseElse.incrementAndGet();
            return alternativeString;
        };
        final Nullable<String> n = new Nullable<>(original);
        final Nullable<String> result = n.mapOrGet(supplier);
        Assertions.assertEquals(
            0,
            countUseElse.get(),
            "Testing true map and consumer for non-null case"
        );
        Assertions.assertEquals(
            original,
            result.get(),
            "Testing result for non-null case"
        );
    }
}
