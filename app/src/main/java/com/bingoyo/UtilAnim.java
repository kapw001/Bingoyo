package com.bingoyo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

import static android.view.View.VISIBLE;

public class UtilAnim {


    public static void hideAnimation(final View view) {

        view.animate().setDuration(100)
//                .translationY(view.getHeight())
                .alpha(0.0f)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        view.setVisibility(View.GONE);
                    }
                });
    }

    public static void showAnimation(View view) {

        view.setVisibility(VISIBLE);

        view.setAlpha(0.0f);

// Start the animation
        view.animate().setDuration(1000)
                .translationY(0)
                .alpha(1.0f)
                .setListener(null);

    }


    public static void moveAnimation(final View view) {

        view.setVisibility(VISIBLE);

        view.setAlpha(0.0f);

        view.setY(view.getY() + 50);

// Start the animation
        view.animate().setDuration(1000)
                .translationY(view.getY() - 50)
                .alpha(1.0f)
                .setListener(null);
    }
}
