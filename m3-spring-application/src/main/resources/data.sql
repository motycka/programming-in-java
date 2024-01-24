insert into users (name, weight, date_of_birth, token) values
    ('Alice', 50.5, '1990-01-01', '6?4F-dRakHQf&FU4Qc*Av@'),
    ('Bob', 70.5, '1990-01-02', 'pB_$?h8i$-Eme&u%%nXg7U'),
    ('Charlie', 90.5, '1990-01-03', 'zrfQXQE4qFxJ+QhihFW_iJ'),
    ('David', 110.5, '1990-01-04', 'k6PVh*?^QGr+wf6fdjX9yE')
on conflict do nothing;
