package com.vpexit.mybank.kmm.android.ui.preview

import com.vpexit.mybank.kmm.data.model.banks.Account
import com.vpexit.mybank.kmm.data.model.banks.Bank
import com.vpexit.mybank.kmm.data.model.banks.Operation

object PreviewData {
    val account = Account(
        holder = " Test Test 23",
        balance = 2344.11,
        operations = arrayListOf<Operation>().apply {
            add(Operation(title = "test1", date = "1644784369", amount = "1234.56"))
            add(Operation(title = "test2", date = "1644784369", amount = "1234.56"))
            add(Operation(title = "test3", date = "1644784369", amount = "1234.56"))
            add(Operation(title = "test4", date = "1644784369", amount = "1234.56"))
        })

    val banks = arrayListOf<Bank>().apply {
        add(Bank(name = "test 1", isCA = 1, accounts = arrayListOf<Account>().apply {
            add(
                Account(
                    holder = " Test Test 23",
                    balance = 2344.11,
                    operations = arrayListOf<Operation>().apply {
                        add(Operation(title = "test1", date = "1644784369", amount = "1234.56"))
                        add(Operation(title = "test2", date = "1644784369", amount = "1234.56"))
                        add(Operation(title = "test3", date = "1644784369", amount = "1234.56"))
                        add(Operation(title = "test4", date = "1644784369", amount = "1234.56"))
                    })
            )
            add(Account(holder = " Test Test", balance = 2344.56, operations = arrayListOf()))
            add(Account(holder = " Test Test", balance = 2344.56, operations = arrayListOf()))
        }))
        add(Bank(name = "test 2", isCA = 0, accounts = arrayListOf<Account>().apply {
            add(Account(holder = " Test Test", balance = 2344.56, operations = arrayListOf()))
            add(Account(holder = " Test Test", balance = 2344.56, operations = arrayListOf()))
        }))
        add(Bank(name = "test 3", isCA = 0, accounts = arrayListOf<Account>().apply {
            add(Account(holder = " Test Test", balance = 2344.56, operations = arrayListOf()))
            add(Account(holder = " Test Test", balance = 2344.56, operations = arrayListOf()))
            add(Account(holder = " Test Test", balance = 2344.56, operations = arrayListOf()))
            add(Account(holder = " Test Test", balance = 2344.56, operations = arrayListOf()))
        }))
    }
}