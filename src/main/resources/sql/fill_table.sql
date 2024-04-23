INSERT INTO public.account (id, balance, created_at, type_id, user_id)
VALUES (1, 1000, '2023-03-01 00:00:00.000000', 1, '123e4567-e89b-12d3-a456-426614174023'),
       (2, 2000, '2023-03-02 00:00:00.000000', 2, '123e4567-e89b-12d3-a456-426614174004'),
       (3, 3000, '2023-03-03 00:00:00.000000', 1, '123e4567-e89b-12d3-a456-426614174005'),
       (4, 4000, '2023-03-04 00:00:00.000000', 2, '123e4567-e89b-12d3-a456-426614174006'),
       (5, 5000, '2023-03-05 00:00:00.000000', 1, '123e4567-e89b-12d3-a456-426614174008');


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
insert into fixed_expense (id, amount, label, expense_type_id)
values (1, 362, 'Loyer', 1);
insert into fixed_expense (id, amount, label, expense_type_id)
values (2, 78, 'Facture éléctrique', 2);
insert into fixed_expense (id, amount, label, expense_type_id)
values (3, 11, 'Box Internet', 6);
insert into fixed_expense (id, amount, label, expense_type_id)
values (4, 20, 'Netflix', 4);
insert into fixed_expense (id, amount, label, expense_type_id)
values (5, 17, 'Canal+', 4);
insert into fixed_expense (id, amount, label, expense_type_id)
values (6, 500, 'Budget de consommation', null);

-- INITIAL FILLING MONTHLY_EXPENSE_LIST AND ASSOCIATES TABLES
insert into monthly_expense_list (id, consommation_budget_id, is_active)
values (1, 6, true);

insert into monthly_expense_list_bill_list (monthly_expense_list_id, bill_list_id)
values (1, 1);
insert into monthly_expense_list_bill_list (monthly_expense_list_id, bill_list_id)
values (1, 2);
insert into monthly_expense_list_bill_list (monthly_expense_list_id, bill_list_id)
values (1, 3);