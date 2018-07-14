package com.joachimneumann.bisq


import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.joachimneumann.bisq.Database.BisqNotification

import com.joachimneumann.bisq.Database.NotificationRepository

class BisqNotificationViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository: NotificationRepository
    var bisqNotifications: LiveData<List<BisqNotification>>

    init {
        mRepository = NotificationRepository(application)
        bisqNotifications = mRepository.allBisqNotifications
    }

    fun insert(bisqNotification: BisqNotification) {
        mRepository.insert(bisqNotification)
    }

    fun erase() {
        mRepository.erase()
    }

    fun getFromID(id: Int): BisqNotification {
        return mRepository.getFromID(id)
    }

    fun markAllAsRead() {
        mRepository.markAllAsRead()
    }
}
