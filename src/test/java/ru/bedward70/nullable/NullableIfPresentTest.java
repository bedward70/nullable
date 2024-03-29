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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * IfPresent test cases for {@link Nullable}.
 * @since 0.01
 * @checkstyle JavadocMethodCheck (500 lines)
 * @checkstyle LocalFinalVariableNameCheck (500 lines)
 */
public final class NullableIfPresentTest {

    @Test
    public void testForNull() {
        final Nullable<String> n = new Nullable<>(null);
        final AtomicInteger countUsePredicate = new AtomicInteger();
        n.ifPresent(
            value -> {
                countUsePredicate.incrementAndGet();
            }
        );
        Assertions.assertEquals(
            0,
            countUsePredicate.get(),
            "Testing count for null case"
        );
    }

    @Test
    public void testForNonNull() {
        final String string = "value for count";
        final Nullable<String> n = new Nullable<>(string);
        final AtomicInteger countUsePredicate = new AtomicInteger();
        n.ifPresent(
            value -> {
                countUsePredicate.incrementAndGet();
                Assertions.assertEquals(
                    string,
                    value,
                    "Test executing  value"
                );
            }
        );
        Assertions.assertEquals(
            1,
            countUsePredicate.get(),
            "Testing count for non-null case"
        );
    }
}
