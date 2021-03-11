package com.example.happyexercise

class ExerciseModel(
    private var id: Int,
    private var name: String,
    private var img: Int,
    private var isComplete: Boolean,
    private var isSelected: Boolean,
) {
    fun getId(): Int{
        return  id
    }
    fun setId(id: Int){
        this.id = id
    }
    fun getName(): String{
        return name
    }
    fun setName(name: String){
        this.name = name
    }
    fun getImg(): Int{
        return img
    }
    fun setImg(img: Int){
        this.img = img
    }
    fun getIsComplete(): Boolean{
        return isComplete
    }
    fun setIsComplete(isComplete: Boolean){
        this.isComplete = isComplete
    }
    fun getIsSelectd(): Boolean{
        return isSelected

    }
    fun setIsSelected(isSelected: Boolean){
        this.isSelected = isSelected
    }
}