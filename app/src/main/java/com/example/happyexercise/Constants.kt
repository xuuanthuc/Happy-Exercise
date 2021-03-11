package com.example.happyexercise

class Constants {
    companion object{
        fun defaultExercise():ArrayList<ExerciseModel>{
            val exerciseList = ArrayList<ExerciseModel>()
            val jumpingJacks = ExerciseModel(1,"Jumping Jacks", R.drawable.ic_jumping_jack, false,false)
            exerciseList.add(jumpingJacks)
            val squatJumping = ExerciseModel(2,"Squat Jumping", R.drawable.ic_squat_jumping, false,false)
            exerciseList.add(squatJumping)
            val abdominal = ExerciseModel(3,"Abdominal", R.drawable.ic_abdominal, false,false)
            exerciseList.add(abdominal)
            val abdominalCrunch = ExerciseModel(4,"Abdominal Crunch", R.drawable.ic_abdominal_crunch, false,false)
            exerciseList.add(abdominalCrunch)
            val lunge = ExerciseModel(5,"Lunge", R.drawable.ic_lunge, false,false)
            exerciseList.add(lunge)
            val squat = ExerciseModel(6,"Squat", R.drawable.ic_squat, false,false)
            exerciseList.add(squat)
            val plank = ExerciseModel(7,"Plank", R.drawable.ic_plank, false,false)
            exerciseList.add(plank)
            val slidePlank = ExerciseModel(8,"Slide Plank", R.drawable.ic_slide_plank, false,false)
            exerciseList.add(slidePlank)
            val recycleBike = ExerciseModel(9,"Recycle Bike", R.drawable.ic_recycle_bike, false,false)
            exerciseList.add(recycleBike)
            val squatToo = ExerciseModel(10,"Squat", R.drawable.ic_squat_too, false,false)
            exerciseList.add(squatToo)

            return exerciseList
        }
    }
}