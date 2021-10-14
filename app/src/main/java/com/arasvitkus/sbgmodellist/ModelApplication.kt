package com.arasvitkus.sbgmodellist

import android.app.Application
import com.arasvitkus.sbgmodellist.data.db.ModelDatabase
import com.arasvitkus.sbgmodellist.data.repositories.ModelRepository
import com.arasvitkus.sbgmodellist.ui.modellist.ModelViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


class ModelApplication: Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ModelApplication))
        bind() from singleton { ModelDatabase(instance()) }
        bind() from singleton {
            ModelRepository(
                instance()
            )
        }
        bind() from provider {
            ModelViewModelFactory(
                instance()
            )
        }
    }
}