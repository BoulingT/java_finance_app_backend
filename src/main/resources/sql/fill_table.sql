-- INITIAL FILLING EXPENSE_TYPE TABLE
insert into expense_type (id, label)
values (1, 'Loyer');
insert into expense_type (id, label)
values (2, 'Facture éléctrique');
insert into expense_type (id, label)
values (3, 'Facture gaz');
insert into expense_type (id, label)
values (4, 'Abonnement');
insert into expense_type (id, label)
values (5, 'Prêt de consommation');
insert into expense_type (id, label)
values (6, 'Internet');
insert into expense_type (id, label)
values (7, 'Budget consommation');

-- INITIAL FILLING FIXED_EXPENSE TABLE
insert into expense (id, amount, label, expense_type_id)
values (1, 362, 'Loyer', 1);
insert into expense (id, amount, label, expense_type_id)
values (2, 78, 'Facture éléctrique', 2);
insert into expense (id, amount, label, expense_type_id)
values (3, 11, 'Box Internet', 6);
insert into expense (id, amount, label, expense_type_id)
values (4, 20, 'Netflix', 4);
insert into expense (id, amount, label, expense_type_id)
values (5, 17, 'Canal+', 4);
insert into expense (id, amount, label, expense_type_id)
values (6, 500, 'Budget de consommation', 7);

-- INITIAL FILLING MONTHLY_EXPENSE_LIST AND ASSOCIATES TABLES
insert into monthly_expense_list (id, consommation_budget_id, is_active)
values (1, 6, true);

insert into monthly_expense_list_bill_list (monthly_expense_list_id, bill_list_id)
values (1, 1);
insert into monthly_expense_list_bill_list (monthly_expense_list_id, bill_list_id)
values (1, 2);
insert into monthly_expense_list_bill_list (monthly_expense_list_id, bill_list_id)
values (1, 3);