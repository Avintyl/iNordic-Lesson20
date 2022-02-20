package com.example.lesson20.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.lesson20.R
import com.example.lesson20.data.network.retrofit.clients.CatClient.catRetrofit
import com.example.lesson20.databinding.FragmentMainBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainFragment : Fragment(R.layout.fragment_main) {

    private var bindings: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindings = FragmentMainBinding.inflate(layoutInflater, container, false)
        return bindings?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        loadCatImage()

        bindings?.btnRefresh?.setOnClickListener {
            loadCatImage()
        }
    }


    private fun loadCatImage() {
        catRetrofit.getCat()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { listOfCats ->
                    this.bindings?.ivPicture?.let {
                        loadImage(
                            it,
                            listOfCats.first().url
                        )
                    }
                },
                {
                    Toast.makeText(
                        requireContext(),
                        "Не удалось загрузить кота",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            )
    }

    private fun loadImage(iv: ImageView, url: String) {
        Glide.with(this)
            .load(url)
            .into(iv)
    }
}