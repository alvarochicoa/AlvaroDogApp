package com.dogapp.doglistapp.model

class BreedProvider {

    companion object {

        fun getAllBreedList(): List<BreedModel>{
            return breed
        }

        private val breed = listOf<BreedModel>(
            BreedModel("affenpinscher"),
            BreedModel("african"),
            BreedModel("airedale"),
            BreedModel("akita"),
            BreedModel("appenzeller"),
            BreedModel("australian"),
            BreedModel("basenji"),
            BreedModel("beagle"),
            BreedModel("bluetick"),
            BreedModel("borzoi"),
            BreedModel("bouvier"),
            BreedModel("boxer"),
            BreedModel("brabancon"),
            BreedModel("briard"),
            BreedModel("buhund"),
            BreedModel("bulldog"),
            BreedModel("bullterrier"),
            BreedModel("cairn"),
            BreedModel("cattledog"),
            BreedModel("chihuahua"),
            BreedModel("chow")
        )
    }
}