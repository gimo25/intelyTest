insert into PRODUCT (product_id, name) values (35455, 't-shirt');
insert into BRAND (brand_id, name) values (1, 'ZARA');

insert into PRICES (brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
 values (1, parsedatetime('2020-06-14-00.00.00', 'yyyy-MM-dd-HH.mm.ss'),
 parsedatetime('2020-12-31-23.59.59', 'yyyy-MM-dd-HH.mm.ss'), 1, 35455, 0, 35.50, 'EUR');
insert into PRICES (brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
 values (1, parsedatetime('2020-06-14-15.00.00', 'yyyy-MM-dd-HH.mm.ss'),
 parsedatetime('2020-06-14-18.30.00', 'yyyy-MM-dd-HH.mm.ss'), 2, 35455, 1, 25.45, 'EUR');
insert into PRICES (brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
 values (1, parsedatetime('2020-06-15-00.00.00', 'yyyy-MM-dd-HH.mm.ss'),
  parsedatetime('2020-06-15-11.00.00', 'yyyy-MM-dd-HH.mm.ss'), 3, 35455, 1, 30.50, 'EUR');
insert into PRICES (brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
 values (1, parsedatetime('2020-06-15-16.00.00', 'yyyy-MM-dd-HH.mm.ss'),
  parsedatetime('2020-12-31-23.59.59', 'yyyy-MM-dd-HH.mm.ss'), 4, 35455, 1, 38.95, 'EUR');
