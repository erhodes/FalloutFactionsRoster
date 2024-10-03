package com.erhodes.factionsroster.database

import com.erhodes.factionsroster.data.GameData
import com.erhodes.factionsroster.data.Model
import com.erhodes.factionsroster.data.ModelClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * In theory this could be swapped out for database wrappers to handle different platforms if I get to the kotlin multiplatform stuff
 */
class DatabaseWrapper(private val database: AppDatabase, private val scope: CoroutineScope = CoroutineScope(Dispatchers.Default)) {

    fun loadModels(): List<Model> {
        // todo put this on a ui thread?
        val result = ArrayList<Model>()
        val savedModels = database.modelDao().getAll()
        savedModels.forEach {
//            val modelClass = GameData.EnumClasses.valueOf(it.modelClass).modelClass
            val modelClass = ModelClass.fromString(it.name)
            val model = Model(it.name, modelClass, modelClass.loadouts[it.loadout])

            result.add(model)
        }

//        scope.launch(Dispatchers.IO) {
//
//        }

        return result
    }

    fun saveModel(model: Model) {
        //todo proper uuid? Save which weapon loadout was used
        database.modelDao().insert(ModelEntity(1, model.name, model.modelClass.name, 0))
    }
}