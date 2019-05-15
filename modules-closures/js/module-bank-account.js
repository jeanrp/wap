let accountList = [];

let module = (function () {

    function loadHandlers() {
        let createNewAccount = document.getElementById("createNewAccount");
        createNewAccount.onclick = module.processAccount;
    }

    function Account(name, deposit) {
        this.name = name;
        this.deposit = deposit;
    }

    function createAccount(name, deposit) {
        let account = new Account(name, deposit);
        return account;
    }

    function processAccount() {
        let accountListElement = document.getElementById('accountList');
        let accountName = document.getElementById("accountName");
        let deposit = document.getElementById("deposit");
        let account = createAccount(accountName.value, deposit.value);
        let arrayAccountFiltered = accountList.filter(x => x.name === accountName.value);
        let accountListFormat = "";
        console.log(arrayAccountFiltered.length);

        if (accountName.value.trim() === "" || deposit.value.trim() === "" || isNaN(deposit.value.trim())) {
            alert("You must fill the fields before try to create an account and the deposit must be a number!");
            return;
        }        

        if (arrayAccountFiltered.length > 0) {
            let newArray = accountList.filter(x => x.name !== accountName.value);
            arrayAccountFiltered[0].deposit = parseFloat(arrayAccountFiltered[0].deposit) + parseFloat(account.deposit);
            newArray.push(arrayAccountFiltered[0]);
            array = newArray;
        } else {
            accountList.push(account);
        }

        accountList.forEach(function (item, index, arr) {
            accountListFormat += "Account name: " + item.name + " Deposit:" + item.deposit + "\n";
        });

        accountListElement.value = accountListFormat;
    }

    return {
        processAccount: processAccount,
        loadHandlers: loadHandlers
    }


})();

module.loadHandlers();
