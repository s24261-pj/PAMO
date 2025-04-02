package com.example.pamo_s24261;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RecipesFragment extends Fragment {
    private LinearLayout recipesContainer;

    private static final int LOW_CALORIES = 1800;
    private static final int MEDIUM_CALORIES = 2400;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recipes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recipesContainer = view.findViewById(R.id.recipesContainer);

        Bundle args = getArguments();
        double calories = args != null ? args.getDouble("calories", 0) : 0;

        if (calories < LOW_CALORIES) {
            addRecipe("🥗 Sałatka z rukolą i jajkiem", 300,
                    "- Rukola\n- Jajko gotowane\n- Pomidorki cherry\n- Sos winegret");

            addSeparator();

            addRecipe("🥦 Zupa krem z brokułów", 350,
                    "- Brokuły\n- Bulion warzywny\n- Jogurt naturalny\n- Grzanki");

        } else if (calories < MEDIUM_CALORIES) {
            addRecipe("🍗 Kurczak z ryżem i warzywami", 550,
                    "- Pierś z kurczaka\n- Ryż\n- Warzywa\n- Oliwa");

            addSeparator();

            addRecipe("🌯 Tortilla z indykiem", 600,
                    "- Placki tortilla\n- Filet z indyka\n- Warzywa\n- Sos czosnkowy");

        } else {
            addRecipe("🍝 Spaghetti bolognese", 750,
                    "- Makaron\n- Mięso mielone\n- Pomidory\n- Ser");

            addSeparator();

            addRecipe("🍔 Burger wołowy z frytkami", 850,
                    "- Bułka\n- Wołowina\n- Ser\n- Frytki\n- Warzywa");
        }
    }

    private void addRecipe(String title, int kcal, String ingredients) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 0, 0, 16);

        TextView tvTitle = new TextView(getContext());
        tvTitle.setText(title);
        tvTitle.setTextSize(18f);
        tvTitle.setTypeface(null, android.graphics.Typeface.BOLD);
        tvTitle.setLayoutParams(params);

        TextView tvCalories = new TextView(getContext());
        tvCalories.setText("Kaloryczność: " + kcal + " kcal");
        tvCalories.setLayoutParams(params);

        TextView tvIngredients = new TextView(getContext());
        tvIngredients.setText("Składniki:\n" + ingredients);
        tvIngredients.setLayoutParams(params);

        recipesContainer.addView(tvTitle);
        recipesContainer.addView(tvCalories);
        recipesContainer.addView(tvIngredients);
    }

    private void addSeparator() {
        View separator = new View(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                2
        );
        params.setMargins(0, 24, 0, 24);
        separator.setLayoutParams(params);
        separator.setBackgroundColor(Color.LTGRAY);
        recipesContainer.addView(separator);
    }
}
