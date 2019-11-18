package pt.app.foodstuff.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pt.app.foodstuff.R;

public class ShoppingListFragment extends Fragment {
    CheckBox checkBox;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_list, container, false);

        checkBox = (CheckBox) view.findViewById(R.id.checkBox_shopping_list_fridge);

        final View.OnClickListener hListener = new View.OnClickListener() {
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button_shopping_list_ingredient:
                        Toast.makeText(getActivity(), "Seleciona um ingrediente para acrescentar a lista",
                                Toast.LENGTH_LONG).show();
                        break;
                    case R.id.button_shopping_list_recipe:
                        Toast.makeText(getActivity(), "Seleciona uma receita para acrescentar todos os ingredientes necessarios a lista",
                                Toast.LENGTH_LONG).show();
                        break;
                    case R.id.button_shopping_list_calendar:
                        Toast.makeText(getActivity(), "Seleciona um dia para acrecentar todos os ingredientes das receitas desse dia a lista",
                                Toast.LENGTH_LONG).show();
                        break;
                    case R.id.button_shopping_list_add_item:
                        Toast.makeText(getActivity(), "Crie um item vazio para acrescentar a lista, o caso mais normal numa lista de compras normal",
                                Toast.LENGTH_LONG).show();
                        break;
                }
                if (checkBox.isChecked()) {
                    Toast.makeText(getActivity(), "Adiciona os itens da lista ao frigorifico", Toast.LENGTH_LONG).show();
                }
            }
        };

        view.findViewById(R.id.button_shopping_list_ingredient).setOnClickListener(hListener);
        view.findViewById(R.id.button_shopping_list_recipe).setOnClickListener(hListener);
        view.findViewById(R.id.button_shopping_list_calendar).setOnClickListener(hListener);
        view.findViewById(R.id.button_shopping_list_add_item).setOnClickListener(hListener);
        view.findViewById(R.id.checkBox_shopping_list_fridge).setOnClickListener(hListener);

        return view;
    }
}
