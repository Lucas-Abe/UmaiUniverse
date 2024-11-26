package com.example.umaiuniverse.ui.sugestao;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.umaiuniverse.databinding.FragmentSugestaoBinding;

public class SugestaoFragment extends Fragment {

    private FragmentSugestaoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SugestaoViewModel sugestaoViewModel =
                new ViewModelProvider(this).get(SugestaoViewModel.class);

        binding = FragmentSugestaoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSugestao;
        sugestaoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
