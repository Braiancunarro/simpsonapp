package com.aristidevs.simpsonapp.ui.dashboard

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aristidevs.simpsonapp.R
import com.aristidevs.simpsonapp.databinding.FragmentDashboardBinding
import com.aristidevs.simpsonapp.ui.providers.HomeroRandomProviders
import dagger.hilt.android.AndroidEntryPoint
import java.util.Random
import javax.inject.Inject


@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

    @Inject
    lateinit var homeroRandomProviders: HomeroRandomProviders

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initIU()
    }

    private fun initIU() {
       preparePredictions()
        initListeners()
    }

    private fun preparePredictions() {
        val homeroramdom = homeroRandomProviders.getHomero()
        homeroramdom?.let {
            binding.tvQueHomeroEres.text = getString(it.text)
            binding.ivQueHomeroEres.setImageResource(it.image)
        }
    }

    private fun initListeners() {
        binding.ivDonaGira.setOnClickListener { spinDona() }
    }

    private fun spinDona() {
        val random = Random()
        val degrees = random.nextInt(1440) + 360

        val animator =
            ObjectAnimator.ofFloat(binding.ivDonaGira, View.ROTATION, 0f, degrees.toFloat())
        animator.duration = 2000
        animator.interpolator = DecelerateInterpolator()
        animator.doOnEnd { SlideHomero() }
        animator.start()
    }

    private fun SlideHomero() {

        val SlideUpAnimator = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up)
        SlideUpAnimator.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                binding.homerobaba.isVisible = true
            }

            override fun onAnimationEnd(animation: Animation?) {
                growHomero()
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }

        })
        binding.homerobaba.startAnimation(SlideUpAnimator)
    }

    private fun growHomero() {
        val growAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.grow)
        growAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {
                binding.homerobaba.isVisible = false
                QueHomeroEres()
            }

            override fun onAnimationRepeat(animation: Animation?) {}

        })
        binding.homerobaba.startAnimation(growAnimation)

    }

    private fun QueHomeroEres() {
        val disappearAnimation = AlphaAnimation(1.0f, 0.0f)
        disappearAnimation.duration = 200

        val appearAnimation = AlphaAnimation(0.0f, 1.0f)
        appearAnimation.duration = 1000

        disappearAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
                binding.preview.isVisible = false
                binding.preview2.isVisible = true
            }

            override fun onAnimationRepeat(animation: Animation?) {
            }

        })

        binding.preview.startAnimation(disappearAnimation)
        binding.preview2.startAnimation(appearAnimation)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}