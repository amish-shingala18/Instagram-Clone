package com.example.instagram.fragment
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.GestureDetector
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import com.example.instagram.R
import com.example.instagram.activity.MessengerActivity
import com.example.instagram.adapter.PostAdapter
import com.example.instagram.adapter.StoryAdapter
import com.example.instagram.databinding.FragmentHomeBinding
import com.example.instagram.model.PostModel
import com.example.instagram.model.StoryModel
import kotlin.math.abs


class HomeFragment : Fragment() {
    private lateinit var gestureDetector: GestureDetector
    private lateinit var androidComment:String
    private lateinit var androidStudioComment:String
    private lateinit var kotlinComment:String
    private lateinit var flutterComment:String
    private lateinit var rvcjComment:String
    private val swipeThreshold = 100

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val binding = FragmentHomeBinding.bind(view)
        val storyList = mutableListOf<StoryModel>()
        val postList = mutableListOf<PostModel>()
        comments()
        storyList.add(StoryModel(R.drawable.rvcj, "hello "))
        storyList.add(StoryModel(R.drawable.rvcj, "rvcjinsta"))
        storyList.add(StoryModel(R.drawable.android, "android"))
        storyList.add(StoryModel(R.drawable.flutter, "androidstudio"))
        storyList.add(StoryModel(R.drawable.kotlin, "kotlindevelopers"))
        storyList.add(StoryModel(R.drawable.android_studio, "flutter.deviser"))
        storyList.add(StoryModel(R.drawable.android_studio, "flutter.deviser"))
        storyList.add(StoryModel(R.drawable.android_studio, "flutter.deviser"))
        storyList.add(StoryModel(R.drawable.android_studio, "flutter.deviser"))
        storyList.add(StoryModel(R.drawable.android_studio, "flutter.deviser"))
        val storyAdapter = StoryAdapter(storyList)
        binding.rvStory.adapter = storyAdapter

        postList.add(PostModel(R.drawable.android_studio, R.drawable.android_studio, "androidstudio", 240, androidStudioComment))
        postList.add(PostModel(R.drawable.kotlin, R.drawable.kotlin, "kotlindevelopers", 240, kotlinComment))
        postList.add(PostModel(R.drawable.flutter, R.drawable.flutter, "flutter.deviser", 240, flutterComment))
        postList.add(PostModel(R.drawable.android, R.drawable.android, "android", 240, androidComment))
        postList.add(PostModel(R.drawable.rvcj, R.drawable.rvcj, "rvcjinsta", 240, rvcjComment))

        val postAdapter = PostAdapter(postList)
        binding.rvPosts.adapter = postAdapter
        binding.imgMessenger.setOnClickListener {
            intentMessenger()
        }
        activity?.onBackPressedDispatcher!!.addCallback(viewLifecycleOwner) {
            requireActivity().finish()
        }
        gesture()
        binding.cvHome.setOnTouchListener { _, event ->
            gestureDetector.onTouchEvent(event)
            true
        }
        return binding.root
    }
    private fun comments(){
        androidComment =
            "Android OS is a Linux-based mobile operating system that primarily runs on smartphones and tablets. " +
                "The Android platform includes an operating system based upon the Linux kernel, " +
                "a GUI, a web browser and end-user applications that can be downloaded."
        androidStudioComment =
            "Android Studio helps you debug and improve the performance of your code, " +
                    "including inline debugging and performance analysis tools."
        kotlinComment =
            "Kotlin is a modern statically typed programming language used by over 60% of professional " +
                "Android developers that helps boost productivity, developer satisfaction, and code safety."
        flutterComment =
            "Flutter is an open-source mobile application development framework created by Google."
        rvcjComment =
            "You can clearly see that rvcjinsta– the official Instagram account of RVCJ Digital Media Private Limited, " +
                    "is the only Indian publisher account in this list. " +
                    "This shows that RVCJ is not only ruling Facebook but users are interacting with their content on Instagram too."
    }
    private fun intentMessenger() {
        val intent = Intent(activity, MessengerActivity::class.java)
        startActivity(intent)
    }
    private fun gesture() {
        gestureDetector = GestureDetector(activity, object : GestureDetector.SimpleOnGestureListener() {
            override fun onFling(
                e1: MotionEvent?, e2: MotionEvent, velocityX: Float, velocityY: Float
            ): Boolean {
                if (e1 != null && e2 != null) {
                    val deltaX = e2.x - e1.x
                    if (abs(deltaX) > swipeThreshold) {
                        when {
                            deltaX < 0 -> onSwipeRightToLeft()
                            else -> onSwipeLeftToRight()
                        }
                    }
                }
                return true
            }
        })
    }
    private fun onSwipeRightToLeft() {
        intentMessenger()
        Toast.makeText(requireContext(), "Right to Left", Toast.LENGTH_SHORT).show()
    }
    private fun onSwipeLeftToRight() {
        intentMessenger()
        Toast.makeText(requireContext(), "Left to Right", Toast.LENGTH_SHORT).show()
    }
}