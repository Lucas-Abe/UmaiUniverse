package com.example.umaiuniverse.ui.historico;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.umaiuniverse.databinding.FragmentHistoricoBinding;

public class HistoricoFragment extends Fragment {

    private FragmentHistoricoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HistoricoViewModel historicoViewModel =
                new ViewModelProvider(this).get(HistoricoViewModel.class);

        binding = FragmentHistoricoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
