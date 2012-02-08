/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 */

package com.osbcp.cssparser;

import junit.framework.Assert;

import org.junit.Test;

import com.osbcp.cssparser.IncorrectFormatException.ErrorCode;

public final class CSSParserFailingTests {

	@Test
	public void testCommaFirstAsSelector() throws Exception {

		try {
			CSSParser.parse("alpha { width: 100px; } , beta { height: 200px; } ");
			Assert.fail();
		} catch (IncorrectFormatException e) {
			Assert.assertEquals(ErrorCode.FOUND_COLON_WHEN_READING_SELECTOR_NAME, e.getErrorCode());
		}

	}

	@Test
	public void testValueShouldEndWithSemiColon() throws Exception {

		try {
			CSSParser.parse("alpha { width: 100px }");
			Assert.fail();
		} catch (IncorrectFormatException e) {
			Assert.assertEquals(ErrorCode.FOUND_END_BRACKET_BEFORE_SEMICOLON, e.getErrorCode());
		}

	}

}
