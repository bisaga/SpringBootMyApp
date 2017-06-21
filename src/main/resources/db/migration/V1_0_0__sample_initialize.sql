/*
 * Currency
 */
CREATE TABLE currency (
	code 						VARCHAR(60) not null,
	abbreviation 				varchar(60),
	description 				text,
	row_id 						serial primary key,					-- row identifier
	created_at 					timestamptz not null default now(),
	created_by 					varchar(60) not null,
	modified_at 				timestamptz,
	modified_by 				varchar(60)
);
CREATE INDEX currency_created_at ON currency (created_at) ;
CREATE INDEX currency_modified_at ON currency (modified_at) ;

-- DEMO DATA
INSERT INTO public.currency (code, abbreviation, description, created_by)
VALUES('EUR', 'Eur', 'Euro', 'admin');

INSERT INTO public.currency (code, abbreviation, description, created_by)
VALUES('USD', 'Usd', 'US Dollar', 'admin');
