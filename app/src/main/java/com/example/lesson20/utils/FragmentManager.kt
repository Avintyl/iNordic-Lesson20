package com.example.lesson20.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.lesson20.R

fun FragmentManager.navigateTo(fragment: Fragment, addToBackStack: Boolean = false) {
    var transaction = this.beginTransaction()
    if (addToBackStack) transaction = transaction.addToBackStack(null)
    transaction.replace(R.id.fragmentContainer, fragment).commit()
}
