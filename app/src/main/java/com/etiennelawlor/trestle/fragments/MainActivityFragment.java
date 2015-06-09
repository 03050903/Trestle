package com.etiennelawlor.trestle.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.etiennelawlor.trestle.R;
import com.etiennelawlor.trestle.Span;
import com.etiennelawlor.trestle.Trestle;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    // region Member Variables
    private Typeface mRegularFont;
    private Typeface mBoldFont;
    private Typeface mItalicFont;
    private Typeface mBoldItalicFont;
    // endregion

    // Constructors
    public MainActivityFragment() {
    }
    // endregion

    // region Lifecycle Methods
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBoldFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Bold.ttf");
        mItalicFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Italic.ttf");
        mRegularFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-Regular.ttf");
        mBoldItalicFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Roboto-BoldItalic.ttf");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setup single span
        TextView tv1 = (TextView) view.findViewById(R.id.tv1);

        CharSequence formattedText1 = Trestle.getFormattedText(getActivity(),
                new Span.Builder("ForegroundSpan, BackgroundSpan, and CustomTypefaceSpan")
                        .foregroundColor(R.color.purple_100)
                        .backgroundColor(R.color.green_500)
                        .typeface(mItalicFont)
                        .build());

        tv1.setText(formattedText1);

        // Setup multiple spans
        TextView tv2 = (TextView) view.findViewById(R.id.tv2);

        List<Span> spans1 = new ArrayList<>();
        spans1.add(new Span.Builder("ForegroundSpan")
                .foregroundColor(R.color.red_500)
                .build());
        spans1.add(new Span.Builder("BackgroundSpan")
                .backgroundColor(R.color.yellow_500)
                .build());
        spans1.add(new Span.Builder("ForegroundSpan and BackgroundSpan")
                .foregroundColor(R.color.brown_500)
                .backgroundColor(R.color.blue_300)
                .build());
        spans1.add(new Span.Builder("ForegroundSpan, BackgroundSpan, and CustomTypefaceSpan")
                .foregroundColor(R.color.green_700)
                .backgroundColor(R.color.indigo_200)
                .typeface(mRegularFont)
                .build());

        CharSequence formattedText2 = Trestle.getFormattedText(getActivity(), spans1);

        tv2.setText(formattedText2);

        // Setup single span
        TextView tv3 = (TextView) view.findViewById(R.id.tv3);

        CharSequence formattedText3 = Trestle.getFormattedText(getActivity(),
                new Span.Builder("RelativeSizeSpan")
                        .relativeSize(2.0f)
                        .build());

        tv3.setText(formattedText3);

        // Setup single span
        TextView tv4 = (TextView) view.findViewById(R.id.tv4);

        CharSequence formattedText4 = Trestle.getFormattedText(getActivity(),
                new Span.Builder("URLSpan")
                        .isUrl(true)
                        .build());

        tv4.setText(formattedText4);

        // Setup single span
        TextView tv5 = (TextView) view.findViewById(R.id.tv5);

        CharSequence formattedText5 = Trestle.getFormattedText(getActivity(),
                new Span.Builder("UnderlineSpan")
                        .isUnderline(true)
                        .build());

        tv5.setText(formattedText5);

        // Setup single span
        TextView tv6 = (TextView) view.findViewById(R.id.tv6);

        CharSequence formattedText6 = Trestle.getFormattedText(getActivity(),
                new Span.Builder("StrikethroughSpan")
                        .isStrikethru(true)
                        .build());

        tv6.setText(formattedText6);

        // Setup single span
        TextView tv7 = (TextView) view.findViewById(R.id.tv7);

        CharSequence formattedText7 = Trestle.getFormattedText(getActivity(),
                new Span.Builder("QuoteSpan")
                        .quoteColor(R.color.green_500)
                        .build());

        tv7.setText(formattedText7);

        // Setup single span
        TextView tv8 = (TextView) view.findViewById(R.id.tv8);

        List<Span> spans2 = new ArrayList<>();
        spans2.add(new Span.Builder("No Span ")
                .build());
        spans2.add(new Span.Builder("SubscriptSpan ")
                .subscript(true)
                .build());
        spans2.add(new Span.Builder("No Span ")
                .build());
        spans2.add(new Span.Builder("SuperscriptSpan ")
                .superscript(true)
                .build());

        CharSequence formattedText8 = Trestle.getFormattedText(getActivity(), spans2);
        tv8.setText(formattedText8);

        // Setup single span
        TextView tv9 = (TextView) view.findViewById(R.id.tv9);

        CharSequence formattedText9 = Trestle.getFormattedText(getActivity(),
                new Span.Builder("Regex - ForegroundColorSpan, BackgroundColorSpan, and CustomTypefaceSpan")
                        .regex("Span")
                        .foregroundColor(R.color.green_500)
                        .backgroundColor(R.color.red_200)
                        .typeface(mBoldItalicFont)
                        .build());

        tv9.setText(formattedText9);

        // Setup single span
        TextView tv10 = (TextView) view.findViewById(R.id.tv10);

        ClickableSpan clickableSpan = new ClickableSpan(){
            @Override
            public void onClick(View view) {
                if(isAdded() && isResumed()) {
                    Toast.makeText(getActivity().getApplicationContext(), "You clicked on the ClickableSpan", Toast.LENGTH_SHORT).show();
                }
            }
        };

        CharSequence formattedText10 = Trestle.getFormattedText(getActivity(),
                new Span.Builder("ClickableSpan")
                        .clickableSpan(clickableSpan)
                        .build());

        tv10.setMovementMethod(LinkMovementMethod.getInstance());
        tv10.setText(formattedText10);

    }
    // endregion

}
