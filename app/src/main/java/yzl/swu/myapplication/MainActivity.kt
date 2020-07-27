package yzl.swu.myapplication

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * Activity用来管理界面的  生命周期和交互
         * 具体界面需要自己来配置  res -> layout -> .xml
         *  通过setContentView来关联Layout布局文件和Java/kotlin代码
         *  资源文件都会有一个静态资源ID对应   调用资源使用ID
         *  R.layout.drawble
         * */
        setContentView(R.layout.activity_main)

        //监听按钮点击事件
//        mLoginBtn.setOnClickListener(this)
//        mLoginBtn.setOnClickListener({
//            println("dsoajsdo")
//        })

        //apply 添加匿名扩展方法   <T> T.apply(block: T.() -> Unit): T
        mLoginBtn.setOnClickListener {
            ObjectAnimator.ofFloat(imageView2,"rotation",0f,360f).apply {
                duration = 300
                repeatCount = 1
                start()
                addListener(object :MyAnimatorListener(){
                    override fun onAnimationEnd(animation: Animator?) {
                        super.onAnimationEnd(animation)
                        //界面跳转
                        startActivity(Intent(this@MainActivity,Logined::class.java))
                    }
                })
            }
        }

        //also代码块，it代指使用 also的对象
        //<T> T.also(block: (T) -> Unit): T
//        mLoginBtn.setOnClickListener {
//            ObjectAnimator.ofFloat(imageView2,"rotation",0f,360f).also {
//                it.duration = 300
//                it.repeatCount = 1
//                it.start()
//                it.addListener(object :Animator.AnimatorListener{
//                    override fun onAnimationRepeat(animation: Animator?) {
//
//                    }
//
//                    override fun onAnimationEnd(animation: Animator?) {
//                        //界面跳转
//                    startActivity(Intent(this@MainActivity,Logined::class.java))
//                    }
//
//                    override fun onAnimationCancel(animation: Animator?) {
//
//                    }
//
//                    override fun onAnimationStart(animation: Animator?) {
//
//                    }
//
//                })
//            }
//        }
//            //图片旋转动画    动画结束后跳转界面
//            val anim = ObjectAnimator.ofFloat(imageView2,"rotation",0f,360f)
//            anim.duration = 300
//            anim.repeatCount = 2
//            anim.start()
//
//            //监听动画事件结束
//            anim.addListener(object : Animator.AnimatorListener{
//                override fun onAnimationRepeat(animation: Animator?) {
//
//                }
//
//                override fun onAnimationEnd(animation: Animator?) {
//                    //界面跳转
//                    startActivity(Intent(this@MainActivity,Logined::class.java))
//                }
//
//                override fun onAnimationCancel(animation: Animator?) {
//
//                }
//
//                override fun onAnimationStart(animation: Animator?) {
//
//                }
//
//            })
//
//            //界面跳转
//            //startActivity(Intent(this,Logined::class.java))
//        }
//    }

//    override fun onClick(v: View?) {
//        println("here11111")
    }
}