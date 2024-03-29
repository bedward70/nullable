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

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * ToString test cases for {@link Nullable}.
 * @since 0.01
 * @checkstyle JavadocMethodCheck (500 lines)
 * @checkstyle StringLiteralsConcatenationCheck (500 lines)
 */
public final class NullableToStringTest {

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test(final NullableToStringTestData kit) {
        Assertions.assertEquals(
            kit.getExpected(),
            new Nullable(kit.getValue()).toString(),
            "Testing : " + kit
        );
    }

    static Stream<NullableToStringTestData> dataProvider() {
        return Stream.of(
            new NullableToStringTestData(null, "Nullable.null"),
            new NullableToStringTestData(1, "Nullable[1]"),
            new NullableToStringTestData('C', "Nullable[C]"),
            new NullableToStringTestData("String", "Nullable[String]"),
            new NullableToStringTestData(true, "Nullable[true]"),
            new NullableToStringTestData(false, "Nullable[false]")
        );
    }
}
