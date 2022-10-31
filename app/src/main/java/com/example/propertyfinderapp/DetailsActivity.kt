package com.example.propertyfinderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
//        as backButton is present in the detailsActivity
//        so we give the fun to backButton
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener { finish() }
        val titleTextView=findViewById<TextView>(R.id.titleTextView)
        val descriptionTextView=findViewById<TextView>(R.id.descriptiontextview)
        val bedroomsTextView=findViewById<TextView>(R.id.bedroomstextview)
        val bathroomsTextView=findViewById<TextView>(R.id.bathroomstextview)
        val yearsTextView=findViewById<TextView>(R.id.yeartextview)
        val imageView=findViewById<ImageView>(R.id.imageView)

//        by doing finish function we can go to back

//        we need the extras which are declared in the main activity
        val intent =intent
        val extras=intent.extras
//        extras get all the info about extras from the intent
        val title=extras!!.getString("titlesKey")
//       the title which are received ,they have to put it in the title textview
        titleTextView.text=title
//        we give two exclamation because the title is optional
        val description=extras.getString("descriptionKey")
        descriptionTextView.text=description

        val beds=extras.getString("bedsKey")
        bedroomsTextView.text=beds.toString()

        val baths=extras.getString("bathsKey")
        bathroomsTextView.text=baths.toString()

        val year=extras.getString("yearsKey")
        yearsTextView.text=year.toString()

        val images=extras.getIntegerArrayList("imagesKey")
//        default index=0;
        var index=0
        imageView.setImageResource(images!![index])
//        as it is may or may not be exist so we have to give two exclamation mark

//        what happen when we click on the imageView
//        here there are three elements
//        0,1,2
        imageView.setOnClickListener{
            index++
            if(index==images.size)
            {
                index=0
                imageView.setImageResource(images[index])
            }
//            showNextImage(index,images)
        }




//        extras.putInt("bedsKey",beds[index])
//        extras.putInt("bathsKey",baths[index])
//        extras.putInt("yearsKey",years[index])
//        extras.putString("titleKey",titles[index])
//        extras.putString("bedsKey",descriptions[index])
//        the key is of exactly same spelling if  it is not same then not working

    }
}
//    private fun showNextImage(index:Int, imageArray: ArrayList<Int>)
//    {
//        var mIndex=index
//        val imageView=findViewById<ImageView>(R.id.imageView)
//        if(mIndex==imageArray.size) {
//            mIndex = 0
//            imageView.setImageResource(imageArray[mIndex])
//        }
//
//    }