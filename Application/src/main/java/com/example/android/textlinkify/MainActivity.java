/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.textlinkify;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.LineBackgroundSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.widget.TextView;

/**
 * This sample demonstrates https://code.google.com/p/android/issues/detail?id=197281
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sample_main);

        TextView textViewIntro = (TextView) findViewById(R.id.text_intro);
        textViewIntro.setMovementMethod(LinkMovementMethod.getInstance());

        SpannableString ss = new SpannableString(
            "Maecenas sed diam eget risus varius blandit sit amet non magna. Vestibulum id ligula porta felis euismod semper. Nullam id dolor id nibh ultricies vehicula ut id elit. Maecenas faucibus mollis interdum. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum.");
        int startIndex = ss.toString().indexOf("dolor");
        int endIndex = ss.toString().indexOf("Aenean");
        ss.setSpan(new GreenSpan(), startIndex, endIndex,
                Spanned.SPAN_INCLUSIVE_INCLUSIVE);

        TextView textViewSpan = (TextView) findViewById(R.id.text_spannable);
        textViewSpan.setText(ss);
    }

    public class GreenSpan implements LineBackgroundSpan {
        @Override public void drawBackground(
            Canvas c, Paint p, int left, int right, int top, int baseline, int bottom, CharSequence text, int start, int end, int lnum) {
            int prevColor = p.getColor();
            p.setColor(getApplication().getResources().getColor(android.R.color.holo_green_light));
            c.drawRect(left, top, right, bottom, p);
            p.setColor(prevColor);
        }
    }

}
